package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Have the function PrimeChecker(num) take num and return 1 if any arrangement of num comes out to be a prime number,
 * otherwise return 0. For example: if num is 910, the output should be 1 because 910 can be
 * arranged into 109 or 019, both of which are primes.
 *
 * @author Nick Livens
 */
public class PrimeChecker {
    int PrimeChecker(int num) {
        List<Integer> perms = getPermutations("", String.valueOf(num), new ArrayList<Integer>());
        for (int perm : perms) {
            if (isPrime(perm)) {
                return 1;
            }
        }

        return 0;

    }

    boolean isPrime(int num) {
        if (num %2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    List<Integer> getPermutations(String begStr, String endStr, List<Integer> perms) {
        if (endStr.length() <= 1) {
            perms.add(Integer.parseInt(begStr + endStr));
        } else {
            for (int i = 0; i < endStr.length(); i++) {
                String newString = endStr.substring(0, i) + endStr.substring(i + 1);
                getPermutations(begStr + endStr.charAt(i), newString, perms);
            }
        }
        return perms;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        PrimeChecker c = new PrimeChecker();
        System.out.print(c.PrimeChecker(910));
    }
}
