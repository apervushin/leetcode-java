package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {

    public static int[][] merge(final int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[1]));
        final List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; ++i) {
            if (isIntersected(result.get(result.size() - 1), intervals[i])) {
                result.get(result.size() - 1)[1] = Math.max(intervals[i][1], result.get(result.size() - 1)[1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(int[][]::new);
    }

    private static boolean isIntersected(int[] a, int[] b) {
        return (a[0] <= b[0] && a[1] >= b[0]) || (b[0] <= a[0] && b[1] >= a[0]);
    }

    public static void main(final String[] args) {

    }
}
