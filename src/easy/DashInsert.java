package easy;

import java.util.Scanner;

/**
 * Have the function DashInsert(str) insert dashes ('-') between each two odd numbers in str.
 * For example: if str is 454793 the output should be 4547-9-3. Don't count zero as an odd number.
 *
 * @author Nick Livens
 */
public class DashInsert {
    String DashInsert(String str) {
        char[] nums = str.toCharArray();
        int prevNum = Integer.parseInt(String.valueOf(nums[0]));
        StringBuilder result = new StringBuilder(String.valueOf(prevNum));
        for (int i = 1; i < nums.length; i++) {
            int num = Integer.parseInt(String.valueOf(nums[i]));

            if (num != 0 && prevNum % 2 == 1 && num % 2 == 1) {
                result.append("-");
            }
            result.append(num);
            prevNum = num;
        }

        return result.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        DashInsert c = new DashInsert();
        System.out.print(c.DashInsert(s.nextLine()));
    }
}
