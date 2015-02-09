package medium;

import java.util.Scanner;

/**
 * Have the function TripleDouble(num1,num2) take both parameters being passed, and return 1 if there is a straight
 * triple of a number at any place in num1 and also a straight double of the same number in num2.
 * For example: if num1 equals 451999277 and num2 equals 41177722899, then return 1 because in the first parameter
 * you have the straight triple 999 and you have a straight double, 99, of the same number in the second parameter.
 * If this isn't the case, return 0.
 *
 * @author Nick Livens
 */
public class TripleDouble {
    int TripleDouble(long num1, long num2) {
        String num1Str = String.valueOf(num1);
        String num2Str = String.valueOf(num2);

        boolean tripleDouble;
        for (int i = 2; i < num1Str.length(); i++) {
            if (num1Str.charAt(i) == num1Str.charAt(i - 1) && num1Str.charAt(i) == num1Str.charAt(i - 2)) {
                tripleDouble = num2Str.contains(String.valueOf(num1Str.charAt(i)) + String.valueOf(num1Str.charAt(i)));
                if (tripleDouble) return 1;
            }
        }

        return 0;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        TripleDouble c = new TripleDouble();
        System.out.print(c.TripleDouble(451999277L, 41177722899L));
    }
}
