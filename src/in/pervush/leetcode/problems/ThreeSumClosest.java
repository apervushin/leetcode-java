package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    private static final int INF = 1000000;
    public static int threeSumClosest(final int[] nums, final int target) {
        Arrays.sort(nums);

        int result = INF;

        for (int i = 0; i < nums.length; ++i) {
            final int num1 = nums[i];
            final int sum2 = twoSumClosest(nums, target - num1, i);
            final int sum3 = sum2 + num1;
            if (Math.abs(target - sum3) < Math.abs(target - result)) {
                result = sum3;
                if(result == target) {
                    break;
                }
            }
        }

        return result;
    }

    private static int twoSumClosest(final int[] nums, final int target, final int excludedPos) {
        int i = 0;
        int j = nums.length - 1;
        int result = INF;
        while (i < j) {
            if (i == excludedPos) {
                ++i;
                continue;
            }
            if (j == excludedPos) {
                --j;
                continue;
            }

            final int sum2 = nums[i] + nums[j];
            if (Math.abs(target - sum2) < Math.abs(target - result)) {
                result = sum2;
            }

            if (sum2 > target) {
                --j;
            } else if(sum2 < target) {
                ++i;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}
