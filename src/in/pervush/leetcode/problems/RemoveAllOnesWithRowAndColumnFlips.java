package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/
 * Explanation: https://www.youtube.com/watch?v=FO6OuCh9GSA
 */
public class RemoveAllOnesWithRowAndColumnFlips {

    public static boolean removeOnes(final int[][] grid) {

        for (int i = 0; i < grid[0].length; ++i) {
            if (grid[0][i] == 1) {
                for (int j = 0; j < grid.length; ++j) {
                    grid[j][i] = grid[j][i] == 1 ? 0 : 1;
                }
            }
        }

        for (int i = 0; i < grid.length; ++i) {
            int sum = 0;
            for (int j = 0; j < grid[i].length; ++j) {
                sum += grid[i][j];
            }
            if (sum != 0 && sum != grid[i].length) {
                return false;
            }
        }

        return true;
    }
}
