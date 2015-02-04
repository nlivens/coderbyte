package easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Have the function AlphabetSoup(str) take the str string parameter being passed and return the string with
 * the letters in alphabetical order (ie. hello becomes ehllo).
 * Assume numbers and punctuation symbols will not be included in the string.
 *
 * @author Nick Livens
 */
public class AlphabetSoup {
    String AlphabetSoup(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        AlphabetSoup c = new AlphabetSoup();
        System.out.print(c.AlphabetSoup(s.nextLine()));
    }
}
