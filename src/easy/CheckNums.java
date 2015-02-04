package easy;

import java.util.Scanner;

/**
 * Have the function CheckNums(num1,num2) take both parameters being passed and return the string true if num2 is
 * greater than num1, otherwise return the string false.
 * If the parameter values are equal to each other then return the string -1.
 *
 * @author Nick Livens
 */
public class CheckNums {
    String CheckNums(int num1, int num2) {
        if (num2 > num1) {
            return "true";
        } else if (num2 < num1) {
            return "false";
        }

        return "-1";

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        CheckNums c = new CheckNums();
        System.out.print(c.CheckNums(s.nextInt(), s.nextInt()));
    }
}
