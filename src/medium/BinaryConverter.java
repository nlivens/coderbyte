package medium;

import java.util.Scanner;

/**
 * Have the function BinaryConverter(str) return the decimal form of the binary value.
 * For example: if 101 is passed return 5, or if 1000 is passed return 8.
 *
 * @author Nick Livens
 */
public class BinaryConverter {
    int BinaryConverter(String str) {
        return Integer.parseInt(str, 2);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        BinaryConverter c = new BinaryConverter();
        System.out.print(c.BinaryConverter(s.nextLine()));
    }
}
