package easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Have the function SecondGreatLow(arr) take the array of numbers stored in arr and return the second lowest and
 * second greatest numbers, respectively, separated by a space.
 * For example: if arr contains [7, 7, 12, 98, 106] the output should be 12 98.
 * The array will not be empty and will contain at least 2 numbers. It can get tricky if there's just two numbers!
 *
 * @author Nick Livens
 */
public class SecondGreatLow {
    String SecondGreatLow(int[] arr) {
        if (arr.length == 2) {
            return arr[0] + " " + arr[1];
        }

        Arrays.sort(arr);

        int lowest = Integer.MIN_VALUE, highest = Integer.MAX_VALUE;
        int lowestCount = 0, highestCount = 0;
        for (int nr : arr) {
            if (nr > lowest) {
                lowestCount++;
                lowest = nr;

                if (lowestCount == 2) break;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < highest) {
                highestCount++;
                highest = arr[i];

                if (highestCount == 2) break;
            }
        }

        return lowest + " " + highest;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        SecondGreatLow c = new SecondGreatLow();
        System.out.print(c.SecondGreatLow(new int[] {7, 7, 12, 98, 106}));
    }
}
