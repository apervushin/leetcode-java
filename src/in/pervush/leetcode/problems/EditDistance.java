package in.pervush.leetcode.problems;

import in.pervush.leetcode.utils.PrintUtils;

/**
 * https://leetcode.com/problems/edit-distance/description/
 * https://www.youtube.com/watch?v=MiqoA-yF-0M
 */
public class EditDistance {

    public static int minDistance(final String word1, final String word2) {
        final var dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); ++i) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= word2.length(); ++j) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }

        //PrintUtils.print(dp);

        return dp[word1.length()][word2.length()];
    }

    public static void main(final String[] args) {
        System.out.println(minDistance("horse", "ros") + " (" + 3 + ")");
        System.out.println(minDistance("intention", "execution") + " (" + 5 + ")");
        System.out.println(minDistance("zoologicoarchaeologist", "zoogeologist") + " (" + 10 + ")");
    }
}
