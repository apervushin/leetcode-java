package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class FirstUniqueCharacterInAString {

    private static class CharInfo {
        public int cnt;
        public final int firstPos;

        public CharInfo(final int firstPos) {
            this.firstPos = firstPos;
            this.cnt = 1;
        }
    }

    public static int firstUniqChar(final String s) {
        final var stat = new CharInfo[26];
        for (int i = 0; i < s.length(); ++i) {
            final int c = s.charAt(i) - 'a';
            if (stat[c] == null) {
                stat[c] = new CharInfo(i);
            } else {
                stat[c].cnt++;
            }
        }
        return Arrays.stream(stat)
                .filter(v -> v != null && v.cnt == 1)
                .min(Comparator.comparingInt(a -> a.firstPos))
                .map(charInfo -> charInfo.firstPos)
                .orElse(-1);
    }

}
