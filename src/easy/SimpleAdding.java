package easy;

import java.util.Scanner;

/**
 * Have the function SimpleAdding(num) add up all the numbers from 1 to num.
 * For the test cases, the parameter num will be any number from 1 to 1000.
 *
 * @author Nick Livens
 */
public class SimpleAdding {
    int SimpleAdding(int num) {
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            sum += i;
        }

        return sum;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        SimpleAdding c = new SimpleAdding();
        System.out.print(c.SimpleAdding(s.nextInt()));
    }
}
