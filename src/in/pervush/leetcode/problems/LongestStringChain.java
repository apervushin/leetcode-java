package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-string-chain/
 */
public class LongestStringChain {

    private Set<String> wordsMap = new HashSet<>();
    private Map<String, Integer> state = new HashMap<>();

    public int longestStrChain(final String[] words) {
        wordsMap = new HashSet<>(Arrays.asList(words));

        int maxLength = 0;
        for (final String word : words) {
            maxLength = Math.max(longestStrChain(word), maxLength);
        }

        return maxLength;
    }

    private int longestStrChain(final String word) {
        final var cachedMaxLength = state.get(word);
        if (cachedMaxLength != null) {
            return cachedMaxLength;
        }
        int maxLength = 0;

        for (int i = 0; i < word.length(); ++i) {
            final String s = getStringWithoutChar(word, i);
            if (wordsMap.contains(s)) {
                maxLength = Math.max(maxLength, longestStrChain(s));
            }
        }

        ++maxLength;
        state.put(word, maxLength);

        return maxLength;
    }

    private static String getStringWithoutChar(final String word, final int removeIndex) {
        return word.substring(0, removeIndex) + word.substring(removeIndex + 1);
    }

    public static void main(String[] args) {
        final var solution = new LongestStringChain();
        System.out.println(solution.longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}) + " (4)");
        System.out.println(solution.longestStrChain(new String[] {"xbc","pcxbcf","xb","cxbc","pcxbc"}) + " (5)");
        System.out.println(solution.longestStrChain(new String[] {"abcd","dbqca"}) + " (1)");
    }

}
