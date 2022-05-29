package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            int n = Math.abs(nums[i]);
            if(n > nums.length) {
                continue;
            }
            if (nums[n - 1] > 0) {
                nums[n - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,1})); // 2
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12})); // 1
        System.out.println(firstMissingPositive(new int[]{1,2,0})); // 3
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1})); // 2
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12,0,1})); // 2
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1})); // 2

        System.out.println(firstMissingPositive(new int[]{1,2,3})); // 4?
        System.out.println(firstMissingPositive(new int[]{})); // 1?
        System.out.println(firstMissingPositive(new int[]{1})); // 2?
    }
}
