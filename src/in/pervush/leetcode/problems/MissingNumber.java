package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num :  nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1,2,3}));
        System.out.println(missingNumber(new int[]{0,1,2,3}));
        System.out.println(missingNumber(new int[]{0,2,3}));
        System.out.println(missingNumber(new int[]{}));
    }
}
