package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(final int[] nums) {
        int pos = 0;
        int equalElementsCnt = 1;

        for (int i = 1; i <  nums.length; ++i) {
            if (nums[pos] == nums[i]) {
                if (equalElementsCnt++ == 1) {
                    nums[++pos] = nums[i];
                }
            } else {
                equalElementsCnt = 1;
                nums[++pos] = nums[i];
            }
        }

        return pos + 1;
    }

    public static void main(String[] args) {
        int[] input1 = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(input1));
        System.out.println(Arrays.toString(input1));
        System.out.println();

        int[] input2 = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(input2));
        System.out.println(Arrays.toString(input2));
        System.out.println();
    }
}
