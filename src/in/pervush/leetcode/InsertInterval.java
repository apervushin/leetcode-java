package in.pervush.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    public static int[][] insert(final int[][] intervals, final int[] newInterval) {
        int newStart = newInterval[0];
        int newStop = newInterval[1];
        final List<int[]> result = new ArrayList<>();
        boolean inserted = false;

        for (int[] interval : intervals) {
            final int currentStart = interval[0];
            final int currentStop = interval[1];

            if (!isIntersected(currentStart, currentStop, newStart, newStop)) {
                if (currentStop < newStart) {
                    result.add(interval);
                } else if (currentStart > newStop && !inserted) {
                    inserted = true;
                    result.add(new int[]{newStart, newStop});
                    result.add(interval);
                } else {
                    result.add(interval);
                }
            } else {
                newStart = Math.min(newStart, currentStart);
                newStop = Math.max(newStop, currentStop);
            }
        }

        if (!inserted) {
            result.add(new int[]{newStart, newStop});
        }

        int[][] resultArray = new int[result.size()][];
        result.toArray(resultArray);
        return resultArray;
    }

    private static boolean isIntersected(final int interval1Start, final int interval1Stop,
                                         final int interval2Start, final int interval2Stop) {
        return (interval1Start <= interval2Start && interval1Stop >= interval2Start) ||
                (interval2Start <= interval1Start && interval2Stop >= interval1Start);
    }

    private static void test1() {
        int[][] intervals = new int[][]{
                new int[] {1,3},
                new int[] {6,9},
        };
        int[] newInterval = new int[]{2,5};
        int[][] result = insert(intervals, newInterval);
        for (int[] item : result) {
            System.out.print(Arrays.toString(item) + ", ");
        }
        System.out.println();
    }

    private static void test2() {
        int[][] intervals = new int[][]{
                new int[] {1,2},
                new int[] {3,5},
                new int[] {6,7},
                new int[] {8,10},
                new int[] {12,16},
        };
        int[] newInterval = new int[]{4,8};
        int[][] result = insert(intervals, newInterval);
        for (int[] item : result) {
            System.out.print(Arrays.toString(item) + ", ");
        }
        System.out.println();
    }

    private static void test3() {
        int[][] intervals = new int[][]{};
        int[] newInterval = new int[]{4,8};
        int[][] result = insert(intervals, newInterval);
        for (int[] item : result) {
            System.out.print(Arrays.toString(item) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
