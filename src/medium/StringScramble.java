package medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Have the function StringScramble(str1,str2) take both parameters being passed and return the string true if a
 * portion of str1 characters can be rearranged to match str2, otherwise return the string false.
 * For example: if str1 is "rkqodlw" and str2 is "world" the output should return true.
 * Punctuation and symbols will not be entered with the parameters.
 *
 * @author Nick Livens
 */
public class StringScramble {
    boolean StringScramble(String str1, String str2) {
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();

        boolean[] used = new boolean[str1Chars.length];
        Arrays.fill(used, false);

        Arrays.sort(str1Chars);
        Arrays.sort(str2Chars);

        for (char c : str2Chars) {
            boolean found = false;
            for (int i = 0; i < str1Chars.length; i++) {
                if (str1Chars[i] == c && !used[i]) {
                    used[i] = true;
                    found = true;
                    break;
                }
            }

            if (!found) return false;
        }

        return true;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        StringScramble c = new StringScramble();
        System.out.print(c.StringScramble("coodrebtqqkye", "coderbyte"));
    }
}
