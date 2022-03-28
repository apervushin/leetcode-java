package in.pervush.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    public static int jump(final int[] nums) {
        final int inf = Integer.MAX_VALUE;
        final int[] dp = new int[nums.length];
        Arrays.fill(dp, inf);
        dp[0] = 0;

        //System.out.println(Arrays.toString(dp));

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; ++j) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
                //System.out.println(Arrays.toString(dp));
            }
        }

        return dp[dp.length - 1];
    }

    private static void test1() {
        int[] input = new int[]{2,3,1,1,4};
        System.out.println(Arrays.toString(input));
        System.out.println(jump(input));
        System.out.println();
    }

    private static void test2() {
        int[] input = new int[]{2,3,0,1,4};
        System.out.println(Arrays.toString(input));
        System.out.println(jump(input));
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
