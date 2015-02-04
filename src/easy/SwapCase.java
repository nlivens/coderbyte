package easy;

import java.util.Scanner;

/**
 * Have the function SwapCase(str) take the str parameter and swap the case of each character.
 * For example: if str is "Hello World" the output should be hELLO wORLD.
 * Let numbers and symbols stay the way they are.
 *
 * @author Nick Livens
 */
public class SwapCase {
    final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String LOWER = UPPER.toLowerCase();

    String SwapCase(String str) {
        StringBuilder result = new StringBuilder("");

        for (char c : str.toCharArray()) {
            int index = UPPER.indexOf(c);
            if (index != -1) {
                result.append(LOWER.charAt(index));
            } else {
                index = LOWER.indexOf(c);

                if (index != -1) {
                    result.append(UPPER.charAt(index));
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
        SwapCase c = new SwapCase();
        System.out.print(c.SwapCase(s.nextLine()));
    }
}
