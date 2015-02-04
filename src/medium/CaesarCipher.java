package medium;

import java.util.Scanner;

/**
 * Have the function CaesarCipher(str,num) take the str parameter and perform a Caesar Cipher shift on it using
 * the num parameter as the shifting number. A Caesar Cipher works by shifting each letter in the string N places
 * down in the alphabet (in this case N will be num). Punctuation, spaces, and capitalization should remain intact.
 * For example if the string is "Caesar Cipher" and num is 2 the output should be "Ecguct Ekrjgt".
 *
 * @author Nick Livens
 */
public class CaesarCipher {
    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final String UPPER_ALPHABET = ALPHABET.toUpperCase();

    String CaesarCipher(String str, int num) {
        StringBuilder result = new StringBuilder("");
        for (char c : str.toCharArray()) {
            int index = ALPHABET.indexOf(c);
            if (index != -1) {
                index += num;
                if (index > ALPHABET.length() - 1) {
                    index -= ALPHABET.length();
                }

                result.append(ALPHABET.charAt(index));
            } else {
                index = UPPER_ALPHABET.indexOf(c);
                if (index != -1) {
                    index += num;
                    if (index > UPPER_ALPHABET.length() - 1) {
                        index -= UPPER_ALPHABET.length() - 1;
                    }

                    result.append(UPPER_ALPHABET.charAt(index));
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        CaesarCipher c = new CaesarCipher();
        System.out.print(c.CaesarCipher(s.nextLine(), 4));
    }
}
