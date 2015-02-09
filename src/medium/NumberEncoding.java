package medium;

import java.util.Scanner;

/**
 * Have the function NumberEncoding(str) take the str parameter and encode the message according to the following rule:
 * encode every letter into its corresponding numbered position in the alphabet.
 * Symbols and spaces will also be used in the input.
 * For example: if str is "af5c a#!" then your program should return 1653 1#!.
 *
 * @author Nick Livens
 */
public class NumberEncoding {
    final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String NumberEncoding(String str) {
        StringBuilder result = new StringBuilder("");

        for (char c : str.toCharArray()) {
            int index = LOWER.indexOf(c);
            if (index != -1) {
                result.append(index + 1);
            } else {
                index = UPPER.indexOf(c);
                if (index != -1) {
                    result.append(index + 1);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        NumberEncoding c = new NumberEncoding();
        System.out.print(c.NumberEncoding(s.nextLine()));
    }
}
