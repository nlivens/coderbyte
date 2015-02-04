package medium;

import java.util.Scanner;

/**
 * Have the function PalindromeTwo(str) take the str parameter being passed and return the string true if the parameter
 * is a palindrome, (the string is the same forward as it is backward) otherwise return the string false.
 * The parameter entered may have punctuation and symbols but they should not affect whether the string is in fact
 * a palindrome. For example: "Anne, I vote more cars race Rome-to-Vienna" should return true.
 *
 * @author Nick Livens
 */
public class PalindromeTwo {
    boolean PalindromeTwo(String str) {
        String stripped = strip(str);
        String reversed = new StringBuilder(stripped).reverse().toString();
        return stripped.equals(reversed);
    }

    String strip(String str) {
        StringBuilder result = new StringBuilder("");
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        PalindromeTwo c = new PalindromeTwo();
        System.out.print(c.PalindromeTwo(s.nextLine()));
    }
}
