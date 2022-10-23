package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    private static final int MAX_CANDIDATE_VALUE = 50;

    public static List<List<Integer>> combinationSum2(final int[] candidates, final int target) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> current = new ArrayList<>();
        final int[]  candidatesCounts = new int[MAX_CANDIDATE_VALUE + 1];
        for (final int candidate : candidates) {
            candidatesCounts[candidate]++;
        }

        for (int i = 0; i <  candidatesCounts.length; ++i) {
            if (candidatesCounts[i] > 0) {
                candidatesCounts[i]--;
                current.add(i);
                dfs(result, current, candidatesCounts, target - i, i);
                candidatesCounts[i]++;
                current.remove(current.size() - 1);
            }
        }

        return result;
    }

    private static void dfs(final List<List<Integer>> result, final List<Integer> current,
                            final int[] candidatesCounts, final int target, final int startPos) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startPos; i < candidatesCounts.length; ++i) {
            if (candidatesCounts[i] > 0) {
                candidatesCounts[i]--;
                current.add(i);
                dfs(result, current, candidatesCounts, target - i, i);
                candidatesCounts[i]++;
                current.remove(current.size() - 1);
            }
        }
    }

    private static void test1() {
        System.out.println(combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }

    private static void test2() {
        System.out.println(combinationSum2(new int[] {2,5,2,1,2}, 5));
    }

    private static void test3() {
        System.out.println(combinationSum2(new int[] {2}, 1));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
