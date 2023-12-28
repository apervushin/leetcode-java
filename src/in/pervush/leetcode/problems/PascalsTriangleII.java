package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {

    public static List<Integer> getRow(final int rowIndex) {
        final List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; ++i) {
            result.add(0);

        }
        result.set(0, 1);

        for (int i = 1; i <= rowIndex; ++i) {
            int prev = result.get(0);
            for (int j = 1; j <= i; ++j) {
                int current = result.get(j);
                result.set(j, result.get(j) + prev);
                prev = current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
    }
}
