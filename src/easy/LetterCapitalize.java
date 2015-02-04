package easy;

import java.util.Scanner;

/**
 * Have the function LetterCapitalize(str) take the str parameter being passed and capitalize the first letter
 * of each word. Words will be separated by only one space.
 *
 * @author Nick Livens
 */
public class LetterCapitalize {
    String LetterCapitalize(String str) {
        String words[] = str.split("\\s");
        StringBuilder result = new StringBuilder(str);

        int place = 0;
        for (int i = 0; i < words.length; i++) {
            if (place == 0) {
                result.setCharAt(0, Character.toUpperCase(words[i].charAt(0)));
            } else {
                result.setCharAt(place, Character.toUpperCase(words[i].charAt(0)));
            }

            place += words[i].length() + 1;
        }

        return result.toString();

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        LetterCapitalize c = new LetterCapitalize();
        System.out.print(c.LetterCapitalize(s.nextLine()));
    }
}
