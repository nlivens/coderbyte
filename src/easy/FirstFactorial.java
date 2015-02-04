package easy;


import java.util.Scanner;

/**
 * Have the function FirstFactorial(num) take the num parameter being passed and return the factorial of it
 * (ie. if num = 4, return (4 * 3 * 2 * 1)). For the test cases, the range will be between 1 and 18.
 *
 * @author Nick Livens
 */
public class FirstFactorial {
    long FirstFactorial(int num) {
        long result = 1;

        for (int i = 2; i <= num; i++) {
            result *= i;
        }

        return result;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        FirstFactorial c = new FirstFactorial();
        System.out.print(c.FirstFactorial(s.nextInt()));
    }
}
