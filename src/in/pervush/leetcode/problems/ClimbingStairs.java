package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/climbing-stairs/submissions/844020538/
 */
public class ClimbingStairs {

    public static int climbStairs(final int n) {
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(final String[] args) {
        System.out.println(climbStairs(2) + " (2)");
        System.out.println(climbStairs(3) + " (3)");
    }
}
