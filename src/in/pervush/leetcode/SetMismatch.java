package in.pervush.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int duplicated = 0;
        int missing = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                duplicated = nums[i];
            } else if (nums[i - 1] != nums[i] - 1) {
                missing = nums[i] - 1;
            }
        }
        if (missing == 0) {
            if (nums[0] != 1) {
                missing = 1;
            } else {
                missing = nums[nums.length - 1] + 1;
            }
        }
        return new int[] {duplicated, missing};
    }

    public static void main(String[] args) {
        print(findErrorNums(new int[]{1,2,2,4}));
        print(findErrorNums(new int[]{1,2,2,3}));
        print(findErrorNums(new int[]{2,2,3}));
    }

    private static void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
