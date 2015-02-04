package easy;

import java.util.Scanner;

/**
 * Have the function LetterChanges(str) take the str parameter being passed and modify it using the following algorithm.
 * Replace every letter in the string with the letter following it in the alphabet (ie. c becomes d, z becomes a).
 * Then capitalize every vowel in this new string (a, e, i, o, u) and finally return this modified string.
 * @author Nick Livens
 */
public class LetterChanges {
    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final String ALPHABET_UPPER = ALPHABET.toUpperCase();
    final String VOWELS = "aeiou";

    String LetterChanges(String str) {
        StringBuilder newStr = new StringBuilder("");
        for (char c : str.toCharArray()) {
            int index = ALPHABET.indexOf(c);
            if (index > -1) {
                char newChar = index < ALPHABET.length() - 1 ? ALPHABET.charAt(index + 1) : 'a';
                if (VOWELS.indexOf(newChar) > -1) {
                    newChar = Character.toUpperCase(newChar);
                }
                newStr.append(newChar);
            } else {
                index = ALPHABET_UPPER.indexOf(c);
                if (index > -1) {
                    char newChar = index < ALPHABET_UPPER.length() - 1 ? ALPHABET_UPPER.charAt(index + 1) : 'A';
                    newStr.append(newChar);
                } else {
                    newStr.append(c);
                }
            }
        }

        return newStr.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        LetterChanges c = new LetterChanges();
        System.out.print(c.LetterChanges(s.nextLine()));
    }

}
