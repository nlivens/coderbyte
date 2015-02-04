package easy;

import java.util.Scanner;

/**
 * Have the function TimeConvert(num) take the num parameter being passed and return the number of hours and minutes
 * the parameter converts to (ie. if num = 63 then the output should be 1:3).
 * Separate the number of hours and minutes with a colon.
 *
 * @author Nick Livens
 */
public class TimeConvert {
    String TimeConvert(int num) {
        int hours = num / 60;
        int min = num % 60;

        return hours + ":" + min;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        TimeConvert c = new TimeConvert();
        System.out.print(c.TimeConvert(s.nextInt()));
    }
}
