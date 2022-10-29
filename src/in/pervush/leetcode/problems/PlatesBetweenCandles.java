package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/plates-between-candles/
 */
public class PlatesBetweenCandles {

    public static int[] platesBetweenCandles(final String s, final int[][] queries) {
        final List<Integer> candlesPositions = new ArrayList<>();
        final List<Integer> candlesLeftPlatesCount = new ArrayList<>();
        int platesCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (isCandle(s.charAt(i))) {
                candlesPositions.add(i);
                candlesLeftPlatesCount.add(platesCount);
            } else {
                platesCount++;
            }
        }

//        System.out.println(candlesPositions);
//        System.out.println(candlesLeftPlatesCount);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            var indexLeft = Collections.binarySearch(candlesPositions, queries[i][0]);
            if (indexLeft < 0) {
                indexLeft = Math.abs(indexLeft + 1);
            }
            var indexRight = Collections.binarySearch(candlesPositions, queries[i][1]);
            if (indexRight < 0) {
                indexRight = Math.abs(indexRight + 1) - 1;
            }

            if (indexLeft > indexRight) {
                result[i] = 0;
            } else {
                result[i] = candlesLeftPlatesCount.get(indexRight) - candlesLeftPlatesCount.get(indexLeft);
            }
//            System.out.println("(" + queries[i][0] + "," + queries[i][1] + ") -> " + indexLeft + " " + indexRight + " " + result[i]);
        }

        return result;
    }

    private static boolean isCandle(final char c) {
        return c == '|';
    }

    public static void main(final String[] args) {
        System.out.println(Arrays.toString(platesBetweenCandles("**|**|***|", new int[][] {
                new int[] {2,5},
                new int[] {5,9}
        })));
        System.out.println(Arrays.toString(platesBetweenCandles("***|**|*****|**||**|*", new int[][] {
                new int[] {1,17},
                new int[] {4,5},
                new int[] {14,17},
                new int[] {5,11}
        })));
    }
}
