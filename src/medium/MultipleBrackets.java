package medium;

import java.util.Scanner;

/**
 * Have the function MultipleBrackets(str) take the str parameter being passed and return 1 #ofBrackets if the brackets
 * are correctly matched and each one is accounted for. Otherwise return 0. For example: if str is "(hello [world])(!)",
 * then the output should be 1 3 because all the brackets are matched and there are 3 pairs of brackets,
 * but if str is "((hello [world])" the the output should be 0 because the brackets do not correctly match up.
 * Only "(", ")", "[", and "]" will be used as brackets. If str contains no brackets return 1.
 *
 * @author Nick Livens
 */
public class MultipleBrackets {
    String MultipleBrackets(String str) {
        int openBrackets = 0, openSquareBrackets = 0;
        int nrOfBrackets = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                openBrackets++;
                nrOfBrackets++;
            } else if (c == '[') {
                openSquareBrackets++;
                nrOfBrackets++;
            } else if (c == ')' && openBrackets > 0) {
                openBrackets--;
            } else if (c == ']' && openSquareBrackets > 0) {
                openSquareBrackets--;
            } else if (c == ')' || c == ']') {
                return "0";
            }
        }

        return openBrackets == 0 && openSquareBrackets == 0 ? "1 " + nrOfBrackets : "0";
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        MultipleBrackets c = new MultipleBrackets();
        System.out.print(c.MultipleBrackets(s.nextLine()));
    }
}
