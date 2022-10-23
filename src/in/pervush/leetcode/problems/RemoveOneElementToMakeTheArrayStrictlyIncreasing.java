package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 */
public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {

    public static boolean canBeIncreasing(int[] nums) {
        final int n = nums.length;
        int prevIndex = 0;
        boolean removed = false;
        for (int i = 1; i < n; ++i) {
            if (nums[prevIndex] < nums[i]) {
                prevIndex = i;
            } else if (!removed) {
                if (prevIndex == 0) {
                    prevIndex = i;
                } else if (i == n - 1) {
                    // do nothing (actually we could return true)
                } else if (nums[prevIndex] < nums[i + 1]) {
                    // do nothing (we do not change prev element, i-th element removed)
                } else if (nums[prevIndex - 1] < nums[i]) {
                    prevIndex = i;
                } else {
                    return false;
                }
                removed = true;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeIncreasing(new int[] {1,2,10,5,7}));
        System.out.println(canBeIncreasing(new int[] {2,3,1,2}));
        System.out.println(canBeIncreasing(new int[] {1,1,1}));
        System.out.println(canBeIncreasing(new int[] {1,2,3}));
        System.out.println(canBeIncreasing(new int[] {1,3,2,3}));
        System.out.println(canBeIncreasing(new int[] {1,3,1,3}));
    }

}
