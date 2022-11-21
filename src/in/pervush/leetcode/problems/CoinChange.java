package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/coin-change/submissions/844137580/
 */
public class CoinChange {

    private static final int INF = Integer.MAX_VALUE / 2;

    public static int coinChange(final int[] coins, final int amount) {
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[amount] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (final int coin : coins) {
                if (current - coin >= 0 && dp[current - coin] == INF) {
                    dp[current - coin] = dp[current] + 1;
                    queue.add(current - coin);
                }
            }
        }

        return dp[0] == INF ? -1 : dp[0];
    }

    public static void main(final String[] args) {
        System.out.println(coinChange(new int[] {1,2,5}, 11) + " (3)");
        System.out.println(coinChange(new int[] {1,10,100,999}, 1111) + " (5)");
        System.out.println(coinChange(new int[] {2}, 3) + " (-1)");
        System.out.println(coinChange(new int[] {1}, 0) + " (0)");
        System.out.println(coinChange(new int[] {244,125,459,120,316,68,357,320}, 9793) + " (23)");
        System.out.println(coinChange(new int[] {288,160,10,249,40,77,314,429}, 9208) + " (22)");
        System.out.println(coinChange(new int[] {1}, 2) + " (2)");
        System.out.println(coinChange(new int[] {429,171,485,26,381,31,290}, 8440) + " (20)");
        System.out.println(coinChange(new int[] {58,92,387,421,194,208,231}, 7798) + " (21)");
        System.out.println(coinChange(new int[] {388,232,419,338,49,434,4,143}, 4993) + " (13)");
        System.out.println(coinChange(new int[] {1,2147483647}, 2) + " (2)");
        System.out.println(coinChange(new int[] {1}, 1) + " (1)");
    }
}
