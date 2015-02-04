package medium;

import java.util.Scanner;

/**
 * Have the function PrimeTime(num) take the num parameter being passed and return the string true if the parameter
 * is a prime number, otherwise return the string false. The range will be between 1 and 2^16.
 *
 * @author Nick Livens
 */
public class PrimeTime {
    boolean PrimeTime(long num) {
        if (num %2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        PrimeTime c = new PrimeTime();
        System.out.print(c.PrimeTime(123456));
    }
}
