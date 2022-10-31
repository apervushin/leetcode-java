package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/
 */
public class MinimumAdjacentSwapsToMakeAValidArray {

    public static int minimumSwaps(final int[] nums) {
        final int[] minMaxPos = getMinMaxPos(nums, 0, nums.length - 1);
        final int minPos = minMaxPos[0];
        final int maxPos = minMaxPos[1];

        if (minPos == maxPos) {
            return 0;
        } else if (minPos < maxPos) {
            return minPos + (nums.length - maxPos - 1);
        } else {
            return minPos + (nums.length - maxPos - 1) - 1;
        }
    }

    private static int[] getMinMaxPos(final int[] nums, final int startPos, final int endPos) {
        int min = nums[startPos];
        int minPos = 0;
        int max = nums[startPos];
        int maxPos = 0;
        for (int i = startPos + 1; i <= endPos; ++i) {
            if (max <= nums[i]) {
                max = nums[i];
                maxPos = i;
            }
            if (min > nums[i]) {
                min = nums[i];
                minPos = i;
            }
        }
        return new int[] {minPos, maxPos};
    }

    public static void main(final String[] args) {
        System.out.println(minimumSwaps(new int[] {3,4,5,5,3,1}) + " (6)");
        System.out.println(minimumSwaps(new int[] {9}) + " (0)");
    }

}
