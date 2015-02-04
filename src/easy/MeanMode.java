package easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Have the function MeanMode(arr) take the array of numbers stored in arr and return 1 if the mode equals the mean,
 * 0 if they don't equal each other (ie. [5, 3, 3, 3, 1] should return 1 because the mode (3) equals the mean (3)).
 * The array will not be empty, will only contain positive integers, and will not contain more than one mode.
 *
 * @author Nick Livens
 */
public class MeanMode {
    String MeanMode(int[] arr) {
        int mean = 0, mode = 0;

        Arrays.sort(arr);
        int prevNum = arr[0], numCount = 0, highestCount = 0;
        for (int num : arr) {
            mean += num;

            if (num == prevNum) {
                numCount++;
            } else {
                prevNum = num;
                numCount = 1;
            }

            if (numCount > highestCount) {
                mode = prevNum;
                highestCount = numCount;
            }
        }

        mean /= arr.length;

        return mean == mode ? "1" : "0";

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        MeanMode c = new MeanMode();
        System.out.print(c.MeanMode(new int[] {5, 3, 3, 3, 1}));
    }
}
