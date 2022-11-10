package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 */
public class RandomPickWithWeight {

    private static class Solution {

        private final int[] sums;
        private int sum = 0;
        private final Random random = new Random();
        public Solution(final int[] w) {
            this.sums = new int[w.length];

            for (int i = 0; i < w.length; ++i) {
                this.sum += w[i];
                this.sums[i] = this.sum;
            }
        }

        public int pickIndex() {
            final int randomValue = random.nextInt(sum) + 1;
            final var result = Arrays.binarySearch(sums, randomValue);
            return result < 0 ? result * -1 - 1 : result;
        }

    }

    private static void test1() {
        System.out.println("---------");
        Solution solution = new Solution(new int[] {1});
        System.out.println(solution.pickIndex());
    }

    private static void test2() {
        System.out.println("---------");
        Solution solution = new Solution(new int[] {1,3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }

    public static void main(final String[] args) {
        test1();
        test2();
    }
}
