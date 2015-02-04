package easy;

import java.util.Scanner;

/**
 * Have the function ABCheck(str) take the str parameter being passed and return the string true if the
 * characters a and b are separated by exactly 3 places anywhere in the string at least once
 * (ie. "lane borrowed" would result in true because there is exactly three characters between a and b).
 * Otherwise return the string false.
 *
 * @author Nick Livens
 */
public class ABCheck {
    String ABCheck(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a'&& (i + 4) < chars.length && chars[i + 4] == 'b') {
                return "true";
            } else if (chars[i] == 'b'&& (i + 4) < chars.length && chars[i + 4] == 'a') {
                return "true";
            }
        }

        return "false";

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        ABCheck c = new ABCheck();
        System.out.print(c.ABCheck(s.nextLine()));
    }
}
