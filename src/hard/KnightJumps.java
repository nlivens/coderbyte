package hard;

import java.util.Scanner;

/**
 * Using the Java language, have the function KnightJumps(str) read str which will be a string consisting of the
 * location of a knight on a standard 8x8 chess board with no other pieces on the board. The structure of str will be
 * the following: "(x y)" which represents the position of the knight with x and y ranging from 1 to 8. Your program
 * should determine the number of spaces the knight can move to from a given location. For example: if str is "(4 5)"
 * then your program should output 8 because the knight can move to 8 different spaces from position x=4 and y=5.
 *
 * @author Nick Livens
 */
public class KnightJumps {
    int KnightJumps(String str) {
        int x = Integer.parseInt(String.valueOf(str.charAt(1)));
        int y = Integer.parseInt(String.valueOf(str.charAt(3)));
        int[][] moves = new int[][] {{-2, 1}, {-2, -1}, {2, -1}, {2, 1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}};

        int nrOfMoves = 0;
        for (int i = 0; i < moves.length; i++) {
            int newX = x + moves[i][0];
            int newY = y + moves[i][1];

            if (newX >= 1 && newX <= 8 && newY >= 1 && newY <= 8) {
                nrOfMoves++;
            }
        }

        return nrOfMoves;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        KnightJumps c = new KnightJumps();
        System.out.print(c.KnightJumps(s.nextLine()));
    }
}
