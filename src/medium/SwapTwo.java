package medium;

import java.util.Scanner;

/**
 * Have the function SwapII(str) take the str parameter and swap the case of each character.
 * Then, if a letter is between two numbers (without separation), switch the places of the two numbers.
 * For example: if str is "6Hello4 -8World, 7 yes3" the output should be 4hELLO6 -8wORLD, 7 YES3.
 *
 * @author Nick Livens
 */
public class SwapTwo {
    final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String LOWER = UPPER.toLowerCase();
    final String NUMBERS = "0123456789";

    String SwapII(String str) {
        StringBuilder result = new StringBuilder("");

        int prevNumIndex = -1;
        boolean allCharsAfterPrevNum = false;
        for (char c : str.toCharArray()) {
            int index = UPPER.indexOf(c);
            if (index != -1) {
                result.append(LOWER.charAt(index));
            } else {
                index = LOWER.indexOf(c);

                if (index != -1) {
                    result.append(UPPER.charAt(index));
                } else {
                    index = NUMBERS.indexOf(c);
                    if (index != -1) {
                        if (prevNumIndex != -1 && allCharsAfterPrevNum) {
                            char prevNum = result.charAt(prevNumIndex);
                            result.setCharAt(prevNumIndex, c);
                            result.append(prevNum);
                        } else {
                            result.append(c);
                        }
                        allCharsAfterPrevNum = true;
                        prevNumIndex = result.length() - 1;
                    } else {
                        allCharsAfterPrevNum = false;
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        SwapTwo c = new SwapTwo();
        System.out.print(c.SwapII(s.nextLine()));
    }
}
