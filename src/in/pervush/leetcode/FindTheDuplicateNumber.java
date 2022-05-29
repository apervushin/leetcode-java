package in.pervush.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slowPos = 0;
        int fastPos = 0;

        do {
            slowPos = nums[slowPos];
            fastPos = nums[nums[fastPos]];
        } while (slowPos != fastPos);

        slowPos = 0;
        while (slowPos != fastPos) {
            slowPos = nums[slowPos];
            fastPos = nums[fastPos];
        }

        return slowPos;
    }

    // Solution with sort, n*log(n) complexity
    public static int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (prev == nums[i]) {
                return prev;
            }
            prev = nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }
}
