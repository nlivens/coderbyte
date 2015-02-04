package easy;

import java.util.Scanner;

/**
 * Have the function NumberSearch(str) take the str parameter, search for all the numbers in the string,
 * add them together, then return that final number. For example: if str is "88Hello 3World!" the output should be 91.
 * You will have to differentiate between single digit numbers and multiple digit numbers like in the example above.
 * So "55Hello" and "5Hello 5" should return two different answers.
 * Each string will contain at least one letter or symbol.
 *
 * @author Nick Livens
 */
public class NumberAddition {
    final String NUMBERS = "0123456789";

    int NumberAddition(String str) {
        int sum = 0;

        char[] chars = str.toCharArray();
        StringBuilder number = new StringBuilder("");
        for (int i = 0; i < chars.length; i++) {
            if (NUMBERS.indexOf(chars[i]) != -1) {
                number.append(chars[i]);

                if (i == chars.length - 1) {
                    sum += Integer.valueOf(number.toString());
                }
            } else if (number.length() != 0) {
                sum += Integer.valueOf(number.toString());
                number.setLength(0);
            }
        }

        return sum;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        NumberAddition c = new NumberAddition();
        System.out.print(c.NumberAddition(s.nextLine()));
    }
}
