package easy;

import java.util.Scanner;

/**
 * Have the function MultiplicativePersistence(num) take the num parameter being passed which will always be a
 * positive integer and return its multiplicative persistence which is the number of times you must multiply the digits
 * in num until you reach a single digit. For example: if num is 39 then your program should
 * return 3 because 3 * 9 = 27 then 2 * 7 = 14 and finally 1 * 4 = 4 and you stop at 4.
 *
 * @author Nick Livens
 */
public class MultiplicativePersistence {
    int MultiplicativePersistence(int num) {
        return getMultiplicativePersistence(num, 0);
    }

    int getMultiplicativePersistence(int num, int count) {
        String numStr = String.valueOf(num);
        if (numStr.length() == 1) {
            return count;
        }

        int newNum = 1;
        for (char c : numStr.toCharArray()) {
            newNum *= Integer.valueOf(String.valueOf(c));
        }
        return getMultiplicativePersistence(newNum, ++count);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        MultiplicativePersistence c = new MultiplicativePersistence();
        System.out.print(c.MultiplicativePersistence(39));
    }
}
