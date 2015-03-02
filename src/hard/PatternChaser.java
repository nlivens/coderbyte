package hard;

import java.util.Scanner;

/**
 * Using the Java language, have the function PatternChaser(str) take str which will be a string and return the longest
 * pattern within the string. A pattern for this challenge will be defined as: if at least 2 or more adjacent characters
 * within the string repeat at least twice. So for example "aabecaa" contains the pattern aa, on the other hand
 * "abbbaac" doesn't contain any pattern. Your program should return yes/no pattern/null.
 * So if str were "aabejiabkfabed" the output should be yes abe. If str were "123224" the output should return no null.
 * The string may either contain all characters (a through z only), integers, or both.
 * But the parameter will always be a string type. The maximum length for the string being passed in will be
 * 20 characters. If a string for example is "aa2bbbaacbbb" the pattern is "bbb" and not "aa".
 * You must always return the longest pattern possible.
 *
 * @author Nick Livens
 */
class PatternChaser {
    String PatternChaser(String str) {
        String pattern = null;
        int patternCount;

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String subStr = str.substring(i, j + 1);
                patternCount = 1;

                for (int k = 0; k < str.length() - subStr.length() + 1; k++) {
                    if (k == i) continue;
                    if (subStr.equals(str.substring(k, k + subStr.length()))) {
                        patternCount++;
                    }
                }

                if (patternCount >= 2 && (pattern == null || pattern.length() < subStr.length())) {
                    pattern = subStr;
                }
            }
        }


        return pattern != null ? "yes " + pattern : "no null";

    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        PatternChaser c = new PatternChaser();
        System.out.print(c.PatternChaser(s.nextLine()));
    }
}

