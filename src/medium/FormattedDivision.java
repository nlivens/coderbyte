package medium;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Have the function FormattedDivision(num1,num2) take both parameters being passed, divide num1 by num2, and return
 * the result as a string with properly formatted commas and 4 significant digits after the decimal place.
 * For example: if num1 is 123456789 and num2 is 10000 the output should be "12,345.6789".
 * The output must contain a number in the one's place even if it is a zero.
 *
 * @author Nick Livens
 */
public class FormattedDivision {
    String FormattedDivision(double num1, double num2) {
        double div = num1 / num2;
        DecimalFormat decFormat = new DecimalFormat("#,###,##0.0000");
        return decFormat.format(div);

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        FormattedDivision c = new FormattedDivision();
        System.out.print(c.FormattedDivision(2, 3));
    }
}
