package medium;

import java.util.Scanner;

/**
 * Have the function BracketMatcher(str) take the str parameter being passed and return 1 if the brackets are correctly
 * matched and each one is accounted for. Otherwise return 0. For example: if str is "(hello (world))", then the output
 * should be 1, but if str is "((hello (world))" the the output should be 0 because the brackets do not correctly
 * match up. Only "(" and ")" will be used as brackets. If str contains no brackets return 1.
 *
 * @author Nick Livens
 */
public class BracketMatcher {
    int BracketMatcher(String str) {
        int openBrackets = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                openBrackets++;
            } else if (c == ')' && openBrackets > 0) {
                openBrackets--;
            } else if (c == ')') {
                return 0;
            }
        }

        return openBrackets == 0 ? 1 : 0;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        BracketMatcher c = new BracketMatcher();
        System.out.print(c.BracketMatcher(s.nextLine()));
    }
}
