package medium;

import java.util.Scanner;

/**
 * Have the function LookSaySequence(num) take the num parameter being passed and return the next number in the sequence
 * according to the following rule: to generate the next number in a sequence read off the digits of the given number,
 * counting the number of digits in groups of the same digit.
 * For example, the sequence beginning with 1 would be: 1, 11, 21, 1211, ... The 11 comes from there being "one 1"
 * before it and the 21 comes from there being "two 1's" before it. So your program should return the next number
 * in the sequence given num.
 *
 * @author Nick Livens
 */
public class LookSaySequence {
    String LookSaySequence(int num) {
        if (num < 10) {
            return "1" + num;
        }

        StringBuilder result = new StringBuilder("");
        char[] nums = String.valueOf(num).toCharArray();
        int charCount = 1;
        char prevChar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prevChar) {
                charCount++;
            } else {
                result.append(charCount).append(prevChar);
                charCount = 1;
                prevChar = nums[i];
            }

            if (i == nums.length - 1) {
                result.append(charCount).append(prevChar);
            }
        }

        return result.toString();

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        LookSaySequence c = new LookSaySequence();
        System.out.print(c.LookSaySequence(1211));
    }
}
