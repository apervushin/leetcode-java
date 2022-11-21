package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(final int[] cost) {
        final int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < dp.length; ++ i) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(final String[] args) {
        System.out.println(minCostClimbingStairs(new int[] {10,15,20}) + " (15)");
        System.out.println(minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}) + " (6)");
    }
}
