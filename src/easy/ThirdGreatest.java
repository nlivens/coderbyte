package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Have the function ThirdGreatest(strArr) take the array of strings stored in strArr and return the third largest word
 * within in. So for example: if strArr is ["hello", "world", "before", "all"] your output should be world
 * because "before" is 6 letters long, and "hello" and "world" are both 5, but the output should be world because
 * it appeared as the last 5 letter word in the array. If strArr was ["hello", "world", "after", "all"] the output
 * should be after because the first three words are all 5 letters long, so return the last one.
 * The array will have at least three strings and each string will only contain letters.
 *
 * @author Nick Livens
 */
public class ThirdGreatest {
    String ThirdGreatest(String[] strArr) {
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s, String s2) {
                if (s.length() > s2.length()) {
                    return 1;
                } else if (s.length() == s2.length()) {
                    return 0;
                }
                return -1;
            }
        });

        String last = strArr[strArr.length - 1];
        String secondLast = strArr[strArr.length - 2];
        String thirdLast = strArr[strArr.length - 3];
        if (last.length() == secondLast.length() && last.length() == thirdLast.length()) {
            return last;
        } else if (secondLast.length() == thirdLast.length()) {
            return secondLast;
        }

        return thirdLast;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        ThirdGreatest c = new ThirdGreatest();
        System.out.print(c.ThirdGreatest(new String[] {"hello", "world", "before", "all"}));
    }
}
