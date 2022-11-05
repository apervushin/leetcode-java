package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/counting-words-with-a-given-prefix/
 */
public class CountingWordsWithAGivenPrefix {

    public static int prefixCount(final String[] words, final String pref) {
        int result = 0;

        for (final String word : words) {
            if (word.startsWith(pref)) {
                ++result;
            }
        }

        return result;
    }

}
