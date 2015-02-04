package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Have the function PrimeMover(num) return the numth prime number. The range will be from 1 to 10^4.
 * For example: if num is 16 the output should be 53 as 53 is the 16th prime number.
 *
 * @author Nick Livens
 */
public class PrimeMover {
    static List<Integer> primes = new ArrayList<Integer>();

    int PrimeMover(int num) {
        return primes.get(num - 1);
    }

    static boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);

        for (int i = 1; i <= 10000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        PrimeMover c = new PrimeMover();
        System.out.print(c.PrimeMover(16));
    }
}
