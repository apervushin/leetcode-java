package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable {

    static class NumArray {

        private final int[] numsSums;

        public NumArray(int[] nums) {
            numsSums = new int[nums.length + 1];
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                numsSums[i + 1] = sum;
            }
            //System.out.print(" \t"); print(nums);
            //print(numsSums);
        }

        public int sumRange(int left, int right) {
            return numsSums[right + 1] - numsSums[left];
        }

        private static void print(int[] a) {
            for (int v : a) {
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NumArray solution = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(solution.sumRange(0, 2));
        System.out.println(solution.sumRange(2, 5));
        System.out.println(solution.sumRange(0, 5));
    }

}
