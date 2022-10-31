package in.pervush.leetcode.problems;

import java.util.HashSet;
import java.util.TreeSet;

public class MakeArrayZeroBySubtractingEqualAmounts {

    public static int minimumOperations(final int[] nums) {
        final HashSet<Integer> queue = new HashSet<>();
        for (int i : nums) {
            if (i != 0) {
                queue.add(i);
            }
        }

        return queue.size();
    }

    public static int minimumOperations2(final int[] nums) {
        final TreeSet<Integer> queue = new TreeSet<>();
        for (int i : nums) {
            queue.add(i);
        }

        int result = 0;
        int substruct = 0;
        while (!queue.isEmpty()) {
            final int min = queue.pollFirst() - substruct;
            if (min == 0) {
                continue;
            }
            substruct += min;
            result++;
        }

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(minimumOperations(new int[] {1,2,3,5}));
        System.out.println(minimumOperations(new int[] {1,5,0,3,5}));
        System.out.println(minimumOperations(new int[] {0}));
    }
}
