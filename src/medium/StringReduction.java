package medium;

import java.util.Scanner;

/**
 * Have the function StringReduction(str) take the str parameter being passed and return the smallest number you can
 * get through the following reduction method. The method is: Only the letters a, b, and c will be given in str and you
 * must take two different adjacent characters and replace it with the third. For example "ac" can be replaced with
 * "b" but "aa" cannot be replaced with anything. This method is done repeatedly until the string cannot be further
 * reduced, and the length of the resulting string is to be outputted. For example: if str is "cab", "ca" can be
 * reduced to "b" and you get "bb" (you can also reduce it to "cc"). The reduction is done so the output should be 2.
 * If str is "bcab", "bc" reduces to "a", so you have "aab", then "ab" reduces to "c", and the final string "ac" is
 * reduced to "b" so the output should be 1.
 *
 * @author Nick Livens
 */
public class StringReduction {
    int StringReduction(String str) {
        if (str.length() <= 1) return str.length();

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1 && str.charAt(i) == str.charAt(i - 1)) {
                result += String.valueOf(str.charAt(i));
                continue;
            }

            if (str.charAt(i) != str.charAt(i + 1)) {
                result += String.valueOf(reduct(str.charAt(i), str.charAt(i + 1)));
                if (i < str.length() - 1) {
                    i += 1;
                    result += str.substring(i + 1);
                }

                return StringReduction(result);
            } else {
                result += String.valueOf(str.charAt(i));
            }
        }
        return result.length();
    }

    char reduct(char x, char y) {
        if (x == 'b' && y == 'c') {
            return 'a';
        } else if (x == 'c' && y == 'b') {
            return 'a';
        } else if (x == 'a' && y == 'c') {
            return 'b';
        } else if (x == 'c' && y == 'a') {
            return 'b';
        }
        return 'c';
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        StringReduction c = new StringReduction();
        System.out.print(c.StringReduction(s.nextLine()));
    }
}
