package medium;

import java.util.Scanner;

/**
 * Have the function DashInsertII(str) insert dashes ('-') between each two odd numbers and insert asterisks ('*')
 * between each two even numbers in str. For example: if str is 4546793 the output should be 454*67-9-3.
 * Don't count zero as an odd or even number.
 *
 * @author Nick Livens
 */
public class DashInsertTwo {
    String DashInsertII(String str) {
        char[] nums = str.toCharArray();
        int prevNum = Integer.parseInt(String.valueOf(nums[0]));
        StringBuilder result = new StringBuilder(String.valueOf(prevNum));
        for (int i = 1; i < nums.length; i++) {
            int num = Integer.parseInt(String.valueOf(nums[i]));
            int prevNumDiv = prevNum % 2;
            int numDiv = num % 2;

            if (num != 0 && prevNum != 0) {
                if (prevNumDiv == 1 && numDiv == 1) {
                    result.append("-");
                } else if (prevNumDiv == 0 && numDiv == 0) {
                    result.append("*");
                }
            }

            result.append(num);
            prevNum = num;
        }

        return result.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        DashInsertTwo c = new DashInsertTwo();
        System.out.print(c.DashInsertII(s.nextLine()));
    }
}
