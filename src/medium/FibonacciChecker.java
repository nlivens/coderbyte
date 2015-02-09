package medium;

import java.util.Scanner;

/**
 * Have the function FibonacciChecker(num) return the string yes if the number given is part of the Fibonacci sequence.
 * This sequence is defined by: Fn = Fn-1 + Fn-2, which means to find Fn you add the previous two numbers up.
 * The first two numbers are 0 and 1, then comes 1, 2, 3, 5 etc. If num is not in the Fibonacci sequence,
 * return the string no.
 *
 * @author Nick Livens
 */
public class FibonacciChecker {
    String FibonacciChecker(int num) {

        int fib1 = 0;
        int fib2 = 1;

        while (fib2 < num) {
            int temp = fib1;
            fib1 = fib2;
            fib2 = temp + fib2;
        }

        return fib2 == num ? "yes" : "no";

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        FibonacciChecker c = new FibonacciChecker();
        System.out.print(c.FibonacciChecker(54));
    }
}
