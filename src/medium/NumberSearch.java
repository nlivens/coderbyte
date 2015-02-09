package medium;

import java.util.Scanner;

/**
 * Have the function NumberSearch(str) take the str parameter, search for all the numbers in the string,
 * add them together, then return that final number divided by the total amount of letters in the string.
 * For example: if str is "Hello6 9World 2, Nic8e D7ay!" the output should be 2. First if you add up all the numbers,
 * 6 + 9 + 2 + 8 + 7 you get 32. Then there are 17 letters in the string. 32 / 17 = 1.882, and the final answer should
 * be rounded to the nearest whole number, so the answer is 2. Only single digit numbers separated by spaces will be
 * used throughout the whole string (So this won't ever be the case: hello44444 world).
 * Each string will also have at least one letter.
 *
 * @author Nick Livens
 */
public class NumberSearch {
    final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String LOWER = UPPER.toLowerCase();
    final String NUMBERS = "0123456789";

    int NumberSearch(String str) {
        double sum = 0;
        int charCount = 0;

        for (char c : str.toCharArray()) {
            if (NUMBERS.indexOf(c) != -1) {
                sum += Integer.valueOf(String.valueOf(c));
            } else if (UPPER.indexOf(c) != -1 || LOWER.indexOf(c) != -1) {
                charCount++;
            }
        }

        return (int) Math.round(sum / charCount);

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        NumberSearch c = new NumberSearch();
        System.out.print(c.NumberSearch(s.nextLine()));
    }
}
