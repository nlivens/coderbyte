package easy;

import java.util.Scanner;

/**
 * Have the function AdditivePersistence(num) take the num parameter being passed which will always be a
 * positive integer and return its additive persistence which is the number of times you must add the digits in num
 * until you reach a single digit. For example: if num is 2718 then your program should return 2
 * because 2 + 7 + 1 + 8 = 18 and 1 + 8 = 9 and you stop at 9.
 *
 * @author Nick Livens
 */
public class AdditivePersistence {
    int AdditivePersistence(int num) {
        return getAddPersistence(num, 0);
    }

    int getAddPersistence(int num, int count) {
        String numStr = String.valueOf(num);
        if (numStr.length() == 1) {
            return count;
        }

        int newNum = 0;
        for (char c : numStr.toCharArray()) {
            newNum += Integer.valueOf(String.valueOf(c));
        }
        return getAddPersistence(newNum, ++count);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        AdditivePersistence c = new AdditivePersistence();
        System.out.print(c.AdditivePersistence(2718));
    }
}
