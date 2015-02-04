package medium;

import java.util.Scanner;

/**
 * Have the function RunLength(str) take the str parameter being passed and return a compressed version of the string
 * using the Run-length encoding algorithm. This algorithm works by taking the occurrence of each repeating character
 * and outputting that number along with a single character of the repeating sequence.
 * For example: "wwwggopp" would return 3w2g1o2p. The string will not contain any numbers, punctuation, or symbols.
 *
 * @author Nick Livens
 */
public class RunLength {
    String RunLength(String str) {
        StringBuilder result = new StringBuilder("");

        char[] chars = str.toCharArray();
        char previousChar = chars[0];
        int charCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == previousChar) {
                charCount++;
            } else {
                result.append(charCount).append(previousChar);
                charCount = 1;
                previousChar = chars[i];
            }

            if (i == chars.length - 1) {
                result.append(charCount).append(previousChar);
            }
        }

        return result.toString();

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        RunLength c = new RunLength();
        System.out.print(c.RunLength(s.nextLine()));
    }
}
