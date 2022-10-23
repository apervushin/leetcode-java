package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    private static void swap(final int[] nums, int i, int j) {
        final int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(final int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }
    public static void nextPermutation(final int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int lastIncreasingPos = -1;

        for (int i = 0; i < nums.length - 1; ++i) {

        }

    }

    public static void main(final String[] args) {
        /*
        123
        132
        213
        312
        321
        123

        1234
        1243
        1324
        1342
        1423
        1432
        2134
         */
        int[] input = new int[]{1,2,3};
        for (int i = 0; i < 5; ++i) {
            nextPermutation(input);
            System.out.println(Arrays.toString(input));
        }
    }
}
