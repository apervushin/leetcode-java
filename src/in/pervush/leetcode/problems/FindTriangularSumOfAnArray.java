package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/
 */
public class FindTriangularSumOfAnArray {

    public static int triangularSum(final int[] nums) {
        int n = nums.length;
        while (n > 1) {
            for (int i = 0; i < n - 1; ++i) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            --n;
        }
        return nums[0];
    }

}
