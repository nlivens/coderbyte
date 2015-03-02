package hard;

import java.util.Scanner;

/**
 * Using the Java language, have the function AlphabetRunEncryption(str) read the str parameter being passed which will
 * be an encrypted string and your program should output the original decrypted string. The encryption being used is
 * the following: For every character i in str up to the second to last character, take the i and i+1 characters and
 * encode them by writing the letters of the alphabet, in order, that range in the same direction between those chosen
 * characters. For example: if the original string were bo then it would be encoded as cdefghijklmn, but if the string
 * were boa then bo is encoded as cdefghijklmn and oa is encoded as nmlkjihgfedcb with the final encrypted string being
 * cdefghijklmnnmlkjihgfedcb. So str may be something like the encrypted string just written, and your program should
 * decrypt it and output the original message.
 *
 * The input string will only contains lowercase characters (a...z). There are also three important rules to this
 * encryption based on specific character sequences.
 *
 * 1) If the original string contains only one letter between two chosen characters, such as the string ac then this
 * would be encrypted as bR with R standing for what direction in the alphabet to go in determining the original
 * characters. The encrypted string bR represents ac but the encrypted string bL represents ca (R = right, L = left).
 *
 * 2) If the original string contains zero letters between two chosen characters, such as the string ab then this would
 * be encrypted as abS, with S representing the fact that no decryption is needed on the two letters preceding S.
 * For example, if the original string were aba then the encryption would be abSbaS, but be careful because decrypting
 * this you get abba, but the actual original string is aba.
 *
 * 3) If the original string contains a repeat of letters, such as the string acc then this would be encrypted as bRcN,
 * with N representing the fact that no change in characters occurred on the character preceding N. The input string
 * will never only be composed of repeated characters.
 *
 * @author Nick Livens
 */
public class AlphabetRunEncryption {

    static final char SINGLE_OCCURENCE_RIGHT = 'R';
    static final char SINGLE_OCCURENCE_LEFT = 'L';
    static final char ZERO_OCCURENCES = 'S';
    static final char NO_CHANGE = 'N';
    static final String SPECIALS = "RLSN";

    String AlphabetRunEncryption(String str) {
        StringBuilder result = new StringBuilder("");
        char[] chars = str.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            String piece = findNextPiece(str, i);
            String decryption = decrypt(piece);

            if (i != chars.length - 1 && result.charAt(0) == decryption.charAt(decryption.length() - 1)) {
                result = result.insert(0, decryption.substring(0, decryption.length() - 1));
            } else {
                result = result.insert(0, decryption);
            }

            i -= piece.length() - 1;
        }

        return result.toString();

    }

    String findNextPiece(String str, int start) {
        StringBuilder piece = new StringBuilder("");

        boolean ascending = str.charAt(start) < str.charAt(start - 1);
        for (int i = start; i >= 0; i--) {
            char c = str.charAt(i);
            if (SPECIALS.indexOf(c) != -1 && piece.length() == 0) {
                if (c == SINGLE_OCCURENCE_RIGHT || c == SINGLE_OCCURENCE_LEFT || c == NO_CHANGE) {
                    return str.substring(start - 1, start + 1);
                } else if (c == ZERO_OCCURENCES) {
                    return str.substring(start - 2, start + 1);
                }
            }

            if (i == start) {
                piece = piece.append(c);
                continue;
            }

            char prevC = str.charAt(i + 1);
            if (ascending && c == (char) (prevC + 1)) {
                piece = piece.insert(0, c);
            } else if (!ascending && c == (char) (prevC - 1)) {
                piece = piece.insert(0, c);
            } else {
                break;
            }
        }

        return piece.toString();
    }

    String decrypt(String piece) {
        if (piece.indexOf(SINGLE_OCCURENCE_RIGHT) != -1) {
            char c = piece.charAt(0);
            return String.valueOf((char) (c - 1)) + String.valueOf((char) (c + 1));
        } else if (piece.indexOf(SINGLE_OCCURENCE_LEFT) != -1) {
            char c = piece.charAt(0);
            return String.valueOf((char) (c + 1)) + String.valueOf((char) (c - 1));
        } else if (piece.indexOf(ZERO_OCCURENCES) != -1) {
            return piece.substring(0, 2);
        } else if (piece.indexOf(NO_CHANGE) != -1) {
            char c = piece.charAt(0);
            return String.valueOf(c) + String.valueOf(c);
        }

        char start = piece.charAt(0);
        char end = piece.charAt(piece.length() - 1);
        if (start > end) {
            return String.valueOf((char) (start + 1)) + String.valueOf((char) (end - 1));
        }
        return String.valueOf((char) (start - 1)) + String.valueOf((char) (end + 1));
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        AlphabetRunEncryption c = new AlphabetRunEncryption();
        System.out.print(c.AlphabetRunEncryption(s.nextLine()));
    }

}
