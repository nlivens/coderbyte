package easy;

import java.util.Scanner;

/**
 * Have the function FirstReverse(str) take the str parameter being passed and return the string in reversed order.
 *
 * @author Nick Livens
 */
class FirstReverse {
    String FirstReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        FirstReverse c = new FirstReverse();
        System.out.print(c.FirstReverse(s.nextLine()));
    }

}
