package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class NumberOfDiceRollsWithTargetSum {
    private static final int DIVIDE = (int)Math.pow(10, 9) + 7;

    public static int numRollsToTarget(final int n, final int k, final int target) {
        final int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = 1;

        numRollsToTarget(n, k, target, dp);

        return dp[n][target];
    }

    public static int numRollsToTarget(final int n, final int k, final int target, final int[][] dp) {
        if (target < 0 || (n == 0 && target != 0)) {
            return 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        int result = 0;
        for (int i = 1; i <= k; ++i) {
            result = (result + numRollsToTarget(n - 1, k, target - i, dp)) % DIVIDE;
        }
        dp[n][target] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1, 6, 3));
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTarget(30, 30, 500));
    }
}
