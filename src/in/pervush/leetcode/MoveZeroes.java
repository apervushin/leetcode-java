package in.pervush.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public static void moveZeroes(final int[] nums) {
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            final int val = nums[i];
            if (val == 0) {
                ++zeroCnt;
            } else if (zeroCnt != 0) {
                nums[i - zeroCnt] = nums[i];
            }
        }
        for (int i = nums.length - zeroCnt; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        final int[] input = {0, 0, 0, 0, 0};
        moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}
