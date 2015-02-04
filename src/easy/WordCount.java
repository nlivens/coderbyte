package easy;

import java.util.Scanner;

/**
 * Have the function WordCount(str) take the str string parameter being passed and return the number of words
 * the string contains (ie. "Never eat shredded wheat" would return 4). Words will be separated by single spaces.
 *
 * @author Nick Livens
 */
public class WordCount {
    int WordCount(String str) {
        return str.split("\\s").length;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        WordCount c = new WordCount();
        System.out.print(c.WordCount(s.nextLine()));
    }
}
