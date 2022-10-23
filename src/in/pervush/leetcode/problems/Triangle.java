package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> state = new ArrayList<>();
        for (int i = 0; i < triangle.get(triangle.size() - 1).size() + 1; ++i) {
            state.add(0);
        }

        for (int i = triangle.size() - 1; i >= 0; --i) {
            final List<Integer> newState = new ArrayList<>();
            final List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size(); ++j) {
                newState.add(Math.min(state.get(j), state.get(j + 1)) + current.get(j));
            }
            state = newState;
        }

        return state.get(0);
    }

    private static void test1() {
        final List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(2));
        input.add(List.of(3,4));
        input.add(List.of(6,5,7));
        input.add(List.of(4,1,8,3));

        System.out.println(minimumTotal(input));
    }

    private static void test2() {
        final List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(-10));

        System.out.println(minimumTotal(input));
    }

    private static void test3() {
        final List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(-1));
        input.add(List.of(-2,-3));

        System.out.println(minimumTotal(input));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
