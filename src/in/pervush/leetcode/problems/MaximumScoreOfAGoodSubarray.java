package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/maximum-score-of-a-good-subarray
 */
public class MaximumScoreOfAGoodSubarray {

    public static int maximumScore(final int[] nums, final int k) {
        int leftPos = k;
        int rightPos = k;
        int leftMin = nums[leftPos];
        int rightMin = nums[rightPos];
        int result = nums[k];

        while (leftPos > 0 || rightPos < nums.length) {
            final int leftShiftResult = leftPos > 0 ? nums[leftPos - 1] : 0;
            final int rightShiftResult = rightPos < nums.length - 1 ? nums[rightPos + 1] : 0;
            if (leftShiftResult > rightShiftResult) {
                leftMin = Math.min(leftMin, leftShiftResult);
                --leftPos;
            } else {
                rightMin = Math.min(rightMin, rightShiftResult);
                ++rightPos;
            }

            result = Math.max(result, Math.min(leftMin, rightMin) * (rightPos - leftPos + 1));
        }

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(maximumScore(new int[] {1,4,3,7,4,5}, 3));
    }
}
