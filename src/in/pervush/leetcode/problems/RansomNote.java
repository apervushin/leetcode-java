package in.pervush.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

    public static boolean canConstruct(final String ransomNote, final String magazine) {
        final var chars = countChars(magazine);

        for (int i = 0; i < ransomNote.length(); ++i) {
            final char c = ransomNote.charAt(i);
            final var count = chars.compute(c, (k, v) -> v == null ? -1 : v - 1);
            if (count < 0) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> countChars(final String str) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            chars.compute(str.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        return chars;
    }

}
