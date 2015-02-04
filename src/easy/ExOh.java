package easy;

import java.util.Scanner;

/**
 * Have the function ExOh(str) take the str parameter being passed and return the string true if there is an
 * equal number of x's and o's, otherwise return the string false.
 * Only these two letters will be entered in the string, no punctuation or numbers.
 * For example: if str is "xooxxxxooxo" then the output should return false because there are 6 x's and 5 o's.
 *
 * @author Nick Livens
 */
public class ExOh {
    String ExOh(String str) {
        int xCount = 0, oCount = 0;

        for (char c : str.toCharArray()) {
            if (c == 'x' || c == 'X') {
                xCount++;
            } else if (c == 'o' || c == 'O') {
                oCount++;
            }
        }

        return xCount == oCount ? "true" : "false";

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        ExOh c = new ExOh();
        System.out.print(c.ExOh(s.nextLine()));
    }
}
