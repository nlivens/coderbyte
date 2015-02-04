package medium;

import java.util.Scanner;

/**
 * Have the function Division(num1,num2) take both parameters being passed and return the Greatest Common Factor.
 * That is, return the greatest number that evenly goes into both numbers with no remainder.
 * For example: 12 and 16 both are divisible by 1, 2, and 4 so the output should be 4.
 * The range for both parameters will be from 1 to 10^3.
 * @author Nick Livens
 */
public class Division {
    int Division(int num1, int num2) {
        if (num1 == num2) return num1;
        if (num2 % num1 == 0) return num1;
        if (num1 % num2 == 0) return num2;

        int biggest = num1 > num2 ? num1 : num2;
        int smallest = num1 < num2 ? num1 : num2;

        for (int i = smallest - 1; i >= 1; i--) {
            if (biggest % i == 0 && smallest % i == 0) {
                return i;
            }
        }

        return 1;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        Division c = new Division();
        System.out.print(c.Division(12, 16));
    }
}
