package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Have the function PermutationStep(num) take the num parameter being passed and return the next number greater than
 * num using the same digits. For example: if num is 123 return 132, if it's 12453 return 12534.
 * If a number has no greater permutations, return -1 (ie. 999).
 *
 * @author Nick Livens
 */
public class PermutationStep {
    int PermutationStep(int num) {
        String numStr = String.valueOf(num);
        List<Integer> perms = getPermutations("", numStr, new ArrayList<Integer>());

        Collections.sort(perms);

        int numIndex = perms.indexOf(num);
        if (numIndex == perms.size() - 1) {
            return -1;
        }

        for (int i = numIndex; i < perms.size(); i++) {
            if (perms.get(i) != num) {
                return perms.get(i);
            }
        }

        return -1;
    }

    List<Integer> getPermutations(String begStr, String endStr, List<Integer> perms) {
        if (endStr.length() <= 1) {
            perms.add(Integer.parseInt(begStr + endStr));
        } else {
            for (int i = 0; i < endStr.length(); i++) {
                String newString = endStr.substring(0, i) + endStr.substring(i + 1);
                getPermutations(begStr + endStr.charAt(i), newString, perms);
            }
        }
        return perms;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        PermutationStep c = new PermutationStep();
        System.out.print(c.PermutationStep(41352));
    }
}
