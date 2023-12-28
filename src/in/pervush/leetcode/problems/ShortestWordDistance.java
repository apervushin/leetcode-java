package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/shortest-word-distance/description/
 */
public class ShortestWordDistance {

    public static int shortestDistance(final String[] wordsDict, final String word1, final String word2) {
        int lastWord1Pos = -1;
        int lastWord2Pos = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; ++i) {
            final String word = wordsDict[i];
            if (word.equals(word1)) {
                if (lastWord2Pos != -1) {
                    result = Math.min(result, i - lastWord2Pos);
                }
                lastWord1Pos = i;
            } else if (word.equals(word2)) {
                if (lastWord1Pos != -1) {
                    result = Math.min(result, i - lastWord1Pos);
                }
                lastWord2Pos = i;
            }
        }

        return result;
    }

}
