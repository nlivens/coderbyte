package medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Have the function ArrayAdditionI(arr) take the array of numbers stored in arr and return the string true if any
 * combination of numbers in the array can be added up to equal the largest number in the array, otherwise return the
 * string false. For example: if arr contains [4, 6, 23, 10, 1, 3] the output should return true because
 * 4 + 6 + 10 + 3 = 23. The array will not be empty, will not contain all the same elements,
 * and may contain negative numbers.
 *
 * @author Nick Livens
 */
public class ArrayAddition {
    String ArrayAddition(int[] arr) {
        Arrays.sort(arr);

        int highestNum = arr[arr.length - 1];
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++){
            sum += arr[i];
            for (int j = 0; j < arr.length - 1; j++){
                if (i != j) {
                    sum += arr[j];
                    if (sum == highestNum) {
                        return "true";
                    }
                }
            }
            for (int k = 0; k < arr.length - 1; k++) {
                if (i != k) {
                    sum -= arr[k];
                    if (sum == highestNum) {
                        return "true";
                    }
                }
            }
            sum = 0;
        }

        return "false";
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        ArrayAddition c = new ArrayAddition();
        System.out.print(c.ArrayAddition(new int[] {4, 6, 23, 10, 1, 3}));
    }
}
