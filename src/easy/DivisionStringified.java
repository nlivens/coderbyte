package easy;

import java.util.Scanner;

/**
 * Have the function DivisionStringified(num1,num2) take both parameters being passed, divide num1 by num2, and return
 * the result as a string with properly formatted commas. If an answer is only 3 digits long,
 * return the number with no commas (ie. 2 / 3 should output "1"). For example: if num1 is 123456789 and
 * num2 is 10000 the output should be "12,345".
 *
 * @author Nick Livens
 */
public class DivisionStringified {
    String DivisionStringified(int num1, int num2) {
        String value = String.valueOf(Math.round((float)num1/num2));
        char[] chars = value.toCharArray();
        StringBuilder builder = new StringBuilder();
        int commaCounter = 3;

        for(int i = chars.length - 1; i >= 0; i--)
        {
            builder.insert(0, chars[i]);
            commaCounter--;

            if(commaCounter == 0 && i != 0)
            {
                builder.insert(0, ",");
                commaCounter = 3;
            }
        }

        return builder.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        DivisionStringified c = new DivisionStringified();
        System.out.print(c.DivisionStringified(123456789, 10000));
    }
}
