package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Using the Java language, have the function FarthestNodes(strArr) read strArr which will be an array of hyphenated
 * letters representing paths between those two nodes. For example: ["a-b","b-c","b-d"] means that there is a path
 * from node a to b (and b to a), b to c, and b to d. Your program should determine the longest path that exists in the
 * graph and return the length of that path. So for the example above, your program should return 2 because of the
 * paths a-b-c and d-b-c. The path a-b-c also means that there is a path c-b-a. No cycles will exist in the graph and
 * every node will be connected to some other node in the graph.
 *
 * @author Nick Livens
 */
public class FarthestNodes {
    int FarthestNodes(String[] strArr) {
        List<String> nodes = new ArrayList<String>();
        List<String> connections = new ArrayList<String>();

        for (String connection : strArr) {
            connections.add(connection);

            String[] connectionNodes = connection.split("-");
            for (String node : connectionNodes) {
                if (!nodes.contains(node)) {
                    nodes.add(node);
                }
            }
        }

        Field field = build(nodes, connections);
        int longestDist = 0;
        for (Node node : field.nodes) {
            int longestDistTraveled = travel(node, new ArrayList<Node>(), 0);
            if (longestDistTraveled > longestDist) {
                longestDist = longestDistTraveled;
            }
        }
        return longestDist;
    }

    Field build(List<String> nodeNames, List<String> connections) {
        Field field = new Field();
        for (String nodeName : nodeNames) {
            Node node = new Node(nodeName);
            field.addNode(node);
        }

        for (String connection : connections) {
            String[] neighbours = connection.split("-");
            Node from = field.findNode(neighbours[0]);
            Node to = field.findNode(neighbours[1]);
            from.addConnection(to);
            to.addConnection(from);
        }

        return field;
    }

    int travel(Node node, List<Node> visited, int distance) {
        visited.add(node);

        List<Connection> connections = node.getConnections(visited);
        if (connections.size() == 0) {
            return distance;
        }

        int longestDistance = distance;
        for (Connection connection : connections) {
            int travelDistance = travel(connection.to, visited, distance + 1);
            if (travelDistance > longestDistance) {
                longestDistance = travelDistance;
            }
        }

        return longestDistance;
    }

    class Field {
        List<Node> nodes;

        Field() {
            this.nodes = new ArrayList<Node>();
        }

        void addNode(Node node) {
            this.nodes.add(node);
        }

        Node findNode(String nodeName) {
            for (Node node : nodes) {
                if (node.name.equals(nodeName)) {
                    return node;
                }
            }
            return null;
        }
    }

    class Node {
        String name;
        int weight;
        List<Connection> connections;

        Node(String name) {
            this.name = name;
            this.weight = 0;
            this.connections = new ArrayList<Connection>();
        }

        void addConnection(Node node) {
            Connection connection = new Connection(this, node);
            this.connections.add(connection);
        }

        List<Connection> getConnections(List<Node> visited) {
            List<Connection> connections = new ArrayList<Connection>();
            for (Connection connection : this.connections) {
                boolean valid = true;
                for (Node node : visited) {
                    if (connection.to == node) {
                        valid = false;
                    }
                }

                if (valid) connections.add(connection);
            }
            return connections;
        }
    }

    class Connection {
        Node from;
        Node to;

        Connection(Node from, Node to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        FarthestNodes c = new FarthestNodes();
        System.out.print(c.FarthestNodes(new String[] {"b-a","c-e","b-c","d-c"}));
    }

}
