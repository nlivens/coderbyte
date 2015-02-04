package easy;

import java.util.Scanner;

/**
 * Have the function VowelCount(str) take the str string parameter being passed and return the number of vowels
 * the string contains (ie. "All cows eat grass" would return 5). Do not count y as a vowel for this challenge.
 *
 * @author Nick Livens
 */
public class VowelCount {
    final String VOWELS = "aeiou";
    final String VOWELS_UPPER = VOWELS.toUpperCase();

    int VowelCount(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (VOWELS.indexOf(c) > -1 || VOWELS_UPPER.indexOf(c) > -1) {
                count++;
            }
        }

        return count;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        VowelCount c = new VowelCount();
        System.out.print(c.VowelCount(s.nextLine()));
    }
}
