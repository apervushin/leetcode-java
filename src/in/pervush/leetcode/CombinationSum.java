package in.pervush.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(final int[] candidates, final int target) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> current = new ArrayList<>();

        for (int i = 0; i < candidates.length; ++i) {
            current.add(candidates[i]);
            dfs(result, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1);
        }

        return result;
    }

    private static void dfs(final List<List<Integer>> result, final List<Integer> current, final int[] candidates,
                            final int target, final int startPos) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startPos; i < candidates.length; ++i) {
            current.add(candidates[i]);
            dfs(result, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }

    private static void test1() {
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
    }

    private static void test2() {
        System.out.println(combinationSum(new int[] {2,3,5}, 8));
    }

    private static void test3() {
        System.out.println(combinationSum(new int[] {2}, 1));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
