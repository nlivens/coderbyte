package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Using the Java language, have the function WeightedPath(strArr) take strArr which will be an array of strings which
 * models a non-looping weighted Graph. The structure of the array will be as follows: The first element in the array
 * will be the number of nodes N (points) in the array as a string. The next N elements will be the nodes which can
 * be anything (A, B, C .. Brick Street, Main Street .. etc.). Then after the Nth element, the rest of the elements in
 * the array will be the connections between all of the nodes along with their weights (integers) separated by
 * the pipe symbol (|). They will look like this: (A|B|3, B|C|12 .. Brick Street|Main Street|14 .. etc.).
 * Although, there may exist no connections at all.
 *
 * An example of strArr may be: ["4","A","B","C","D","A|B|1","B|D|9","B|C|3","C|D|4"]. It may help to visualize the
 * Graph by drawing out the nodes and their connections. Your program should return the shortest path when the
 * weights are added up from node to node from the first Node to the last Node in the array separated by dashes.
 * So in the example above the output should be A-B-C-D. Here is another example with strArr being
 * ["7","A","B","C","D","E","F","G","A|B|1","A|E|9","B|C|2","C|D|1","D|F|2","E|D|6","F|G|2"].
 * The output for this array should be A-B-C-D-F-G. There will only ever be one shortest path for the array.
 * If no path between the first and last node exists, return -1. The array will at minimum have two nodes.
 * Also, the connection A-B for example, means that A can get to B and B can get to A.
 * A path may not go through any Node more than once.
 *
 * @author Nick Livens
 */
public class WeightedPath {
    String WeightedPath(String[] strArr) {
        int nrOfNodes = Integer.parseInt(strArr[0]);
        String[] nodes = new String[nrOfNodes];
        String[] connections = new String[strArr.length - nrOfNodes - 1];

        for (int i = 1; i < strArr.length; i++) {
            if (i <= nrOfNodes) {
                nodes[i - 1] = strArr[i];
            } else {
                connections[i - nrOfNodes - 1] = strArr[i];
            }

        }

        Field field = build(nodes, connections);
        Node endNode = field.nodes.get(field.nodes.size() - 1);
        weigh(endNode);
        return field.getShortestPath();
    }

    Field build(String[] nodes, String[] connections) {
        Field field = new Field(nodes);
        for (Node node : field.nodes) {
            for (String connection : connections) {
                if (connection.contains(node.name)) {
                    String[] neighbours = connection.split("[|]");
                    Node neighbour;
                    if (neighbours[0].equals(node.name)) {
                        neighbour = field.findNode(neighbours[1]);
                    } else {
                        neighbour = field.findNode(neighbours[0]);
                    }

                    node.addConnection(neighbour, Integer.parseInt(neighbours[2]));
                }
            }
        }

        return field;
    }

    void weigh(Node node) {
        if (node.end) {
            node.weight = 0;
        }

        for (Connection connection : node.connections) {
            int weight = node.weight + connection.weight;
            Node neigbour = connection.getOther(node);
            if (neigbour.weight == 0 || weight < neigbour.weight) {
                neigbour.weight = weight;

                if (!neigbour.start) {
                    weigh(neigbour);
                }
            }
        }

    }

    class Field {
        int nrOfNodes;
        List<Node> nodes;

        Field(String[] nodes) {
            this.nrOfNodes = nodes.length;
            this.nodes = new ArrayList<Node>();

            for (int i = 0; i < nodes.length; i++) {
                this.nodes.add(new Node(nodes[i], i == 0, i == nodes.length - 1));
            }
        }

        Node findNode(String nodeName) {
            for (Node node : this.nodes) {
                if (node.name.equals(nodeName)) {
                    return node;
                }
            }
            return null;
        }

        String getShortestPath() {
            StringBuilder path = new StringBuilder("");
            Node nextNode = this.nodes.get(0);

            if (nextNode.weight == 0) return "-1";

            path.append(nextNode.name).append("-");
            while ((nextNode = nextNode.getNextNeighbour()) != null) {
                path.append(nextNode.name);
                if (!nextNode.end) {
                    path.append("-");
                }
            }
            return path.toString();
        }
    }

    class Node {
        String name;
        boolean start;
        boolean end;
        int weight;
        List<Connection> connections;

        Node(String name, boolean start, boolean end) {
            this.name = name;
            this.start = start;
            this.end = end;
            this.weight = 0;
            this.connections = new ArrayList<Connection>();
        }

        void addConnection(Node node, int weight) {
            Connection connection = new Connection(this, node, weight);
            this.connections.add(connection);
        }

        Node getNextNeighbour() {
            if (end) return null;

            Node lowestNeighbour = null;
            for (Connection connection : this.connections) {
                Node neighbour = connection.getOther(this);
                if (this.start && neighbour.end && connection.weight == this.weight) {
                    return neighbour;
                }

                if ((!this.start || !neighbour.end) && (lowestNeighbour == null || neighbour.weight == this.weight - connection.weight)) {
                    lowestNeighbour = neighbour;
                }
            }
            return lowestNeighbour;
        }
    }

    class Connection {
        Node from;
        Node to;
        int weight;

        Connection(Node startNode, Node endNode, int weight) {
            this.from = startNode;
            this.to = endNode;
            this.weight = weight;
        }

        Node getOther(Node node) {
            if (from == node) return to;
            if (to == node) return from;
            return null;
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        WeightedPath c = new WeightedPath();
        System.out.print(c.WeightedPath(new String[]{"7","A","B","C","D","E","F","G","A|B|1","A|E|9","B|C|2","C|D|1","D|F|2","E|D|6","F|G|2"}));
    }
}
