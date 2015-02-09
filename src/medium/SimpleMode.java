package medium;

import java.util.Scanner;

/**
 * Have the function SimpleMode(arr) take the array of numbers stored in arr and return the number that appears
 * most frequently (the mode). For example: if arr contains [10, 4, 5, 2, 4] the output should be 4.
 * If there is more than one mode return the one that appeared in the array first (ie. [5, 10, 10, 6, 5]
 * should return 5 because it appeared first). If there is no mode return -1. The array will not be empty.
 *
 * @author Nick Livens
 */
public class SimpleMode {
    int SimpleMode(int[] arr) {
        int mode = 0;

        int numCount = 0, highestCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == i || arr[i] == arr[j]) {
                    numCount++;
                }
            }

            if (numCount > highestCount) {
                mode = arr[i];
                highestCount = numCount;
            }
            numCount = 0;
        }
        return highestCount > 1 ? mode : -1;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        SimpleMode c = new SimpleMode();
        System.out.print(c.SimpleMode(new int[] {2,2,2,5,5,5,6}));
    }
}
