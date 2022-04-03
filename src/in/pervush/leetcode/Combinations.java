package in.pervush.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> current,  int start, int end, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= end; ++i) {
            current.add(i);
            dfs(result, current, i + 1, end, k - 1);
            current.remove(current.size() - 1);
        }
    }

    private static void test1() {
        System.out.println(combine(4, 2));
    }

    private static void test2() {
        System.out.println(combine(4, 3));
    }

    private static void test3() {
        System.out.println(combine(1, 1));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
