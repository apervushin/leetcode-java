package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int num = 1; num <= max; ++num) {
            sum -= num;
        }

        int missing = (int)sum * -1;
        if (missing == 0 && min == 0) {
            missing = max + 1;
        }
        return missing;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();

        System.out.println(solution.missingNumber(new int[]{1,2,3}));
        System.out.println(solution.missingNumber(new int[]{0,1,2,3}));
        System.out.println(solution.missingNumber(new int[]{2,3}));
    }
}
