package easy;

import java.util.Scanner;

/**
 * Have the function SimpleSymbols(str) take the str parameter being passed and determine if it is an acceptable
 * sequence by either returning the string true or false. The str parameter will be composed of + and = symbols
 * with several letters between them (ie. ++d+===+c++==a) and for the string to be true each letter must be
 * surrounded by a + symbol. So the string to the left would be false.
 * The string will not be empty and will have at least one letter.
 *
 * @author Nick Livens
 */
public class SimpleSymbols {
    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final String ALPHABET_UPPER = ALPHABET.toUpperCase();

    String SimpleSymbols(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (ALPHABET.indexOf(c) > -1 || ALPHABET_UPPER.indexOf(c) > -1) {
                if (i == 0 || i == str.length() - 1) {
                    return "false";
                }

                char cp = str.charAt(i - 1);
                char cn = str.charAt(i + 1);

                if (cp != '+' || cn != '+') {
                    return "false";
                }
            }
        }


        return "true";

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        SimpleSymbols c = new SimpleSymbols();
        System.out.print(c.SimpleSymbols(s.nextLine()));
    }
}
