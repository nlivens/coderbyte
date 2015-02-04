package medium;

import java.util.Scanner;

/**
 * Have the function ArithGeoII(arr) take the array of numbers stored in arr and return the string "Arithmetic"
 * if the sequence follows an arithmetic pattern or return "Geometric" if it follows a geometric pattern.
 * If the sequence doesn't follow either pattern return -1. An arithmetic sequence is one where the difference between
 * each of the numbers is consistent, where as in a geometric sequence, each term after the first is multiplied by
 * some constant or common ratio. Arithmetic example: [2, 4, 6, 8] and Geometric example: [2, 6, 18, 54].
 * Negative numbers may be entered as parameters, 0 will not be entered, and no array will contain all the same elements
 *
 * @author Nick Livens
 */
public class ArithGeoTwo {
    String ArithGeoII(int[] arr) {
        if (isArithmetic(arr)) {
            return "Arithmetic";
        } else if (isGeometric(arr)) {
            return "Geometric";
        }

        return "-1";
    }

    boolean isArithmetic(int[] arr) {
        int diff = Math.abs(arr[1] - arr[0]);
        int previousDiff = diff;
        for (int i = 2; i < arr.length; i++) {
            diff = Math.abs(arr[i] - arr[i - 1]);
            if (diff != previousDiff) {
                return false;
            }
            previousDiff = diff;
        }
        return true;
    }

    boolean isGeometric(int[] arr) {
        int diff = arr[1] / arr[0];
        int previousDiff = diff;
        for (int i = 2; i < arr.length; i++) {
            diff = arr[i] / arr[i - 1];
            if (diff != previousDiff) {
                return false;
            }
            previousDiff = diff;
        }
        return true;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        ArithGeoTwo c = new ArithGeoTwo();
        System.out.print(c.ArithGeoII(new int[] {-1, -2, -4, -8}));
    }
}
