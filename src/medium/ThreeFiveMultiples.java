package medium;

import java.util.Scanner;

/**
 * Have the function ThreeFiveMultiples(num) return the sum of all the multiples of 3 and 5 that are below num.
 * For example: if num is 10, the multiples of 3 and 5 that are below 10 are 3, 5, 6, and 9, and adding them up you
 * get 23, so your program should return 23. The integer being passed will be between 1 and 100.
 *
 * @author Nick Livens
 */
public class ThreeFiveMultiples {
    int ThreeFiveMultiples(int num) {
        int sum = 0;
        for (int i = 3; i < num; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        ThreeFiveMultiples c = new ThreeFiveMultiples();
        System.out.print(c.ThreeFiveMultiples(100));
    }
}
