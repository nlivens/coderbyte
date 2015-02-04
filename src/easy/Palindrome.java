package easy;

import java.util.Scanner;

/**
 * Have the function Palindrome(str) take the str parameter being passed and return the string true if the parameter
 * is a palindrome, (the string is the same forward as it is backward) otherwise return the string false.
 * For example: "racecar" is also "racecar" backwards. Punctuation and numbers will not be part of the string.
 *
 * @author Nick Livens
 */
public class Palindrome {
    String Palindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString().replaceAll("\\s", "");
        return str.replaceAll("\\s", "").equals(reversed) ? "true" : "false";
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        Palindrome c = new Palindrome();
        System.out.print(c.Palindrome(s.nextLine()));
    }
}
