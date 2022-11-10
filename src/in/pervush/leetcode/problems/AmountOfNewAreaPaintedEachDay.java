package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/amount-of-new-area-painted-each-day/
 */
public class AmountOfNewAreaPaintedEachDay {

    public static int[] amountPaintedBruteforce(final int[][] paint) {
        final int[] result = new int[paint.length];

        for (int i = 0; i < paint.length; ++i) {
            int[] unpainted = new int[paint[i][1] - paint[i][0]];
            Arrays.fill(unpainted, 1);

            for (int j = 0; j < i; ++j) {
                final int startPos2 = paint[j][0];
                final int endPos2 = paint[j][1];

                if ((startPos2 <= paint[i][0] && endPos2 > paint[i][0])
                        || (paint[i][0] <= startPos2 && paint[i][1] > startPos2)) {
                    Arrays.fill(
                            unpainted,
                            Math.max(startPos2, paint[i][0]) - paint[i][0],
                            Math.min(paint[i][1], endPos2) - paint[i][0],
                            0);
                }

            }

            result[i] = Arrays.stream(unpainted).sum();
        }

        return result;
    }

    public static int[] amountPainted(final int[][] paint) {
        final int[] result = new int[paint.length];
        final TreeMap<Integer, Integer> intervals = new TreeMap<>();

        for (int i = 0; i < paint.length; ++i) {
            int startIndex = paint[i][0];
            int endIndex = paint[i][1];
            int paintLength = endIndex - startIndex;

            var entry = intervals.floorEntry(paint[i][0]);
            if (entry != null) {
                if (entry.getValue() >= endIndex) {
                    result[i] = 0;
                    continue;
                } else if (entry.getValue() >= paint[i][0]) {
                    paintLength -= entry.getValue() - startIndex;
                    intervals.remove(entry.getKey());
                    startIndex = entry.getKey();
                }
            }

            entry = intervals.ceilingEntry(paint[i][0]);
            while (entry != null && entry.getKey() <= endIndex) {
                intervals.remove(entry.getKey());
                paintLength -= Math.min(entry.getValue(), endIndex) - entry.getKey();
                endIndex = Math.max(endIndex, entry.getValue());
                entry = intervals.ceilingEntry(paint[i][0]);
            }

            result[i] = paintLength;
            intervals.put(startIndex, endIndex);
        }

        return result;
    }

    private static void test1() {
        System.out.println(Arrays.toString(amountPainted(new int[][] {
                new int[] {1, 4},
                new int[] {4, 7},
                new int[] {5, 8}
        })) + " ([3, 3, 1])");
    }

    private static void test2() {
        System.out.println(Arrays.toString(amountPainted(new int[][] {
                new int[] {1, 4},
                new int[] {5, 8},
                new int[] {4, 7}
        })) + " ([3, 3, 1])");
    }

    private static void test3() {
        System.out.println(Arrays.toString(amountPainted(new int[][] {
                new int[] {1, 5},
                new int[] {2, 4}
        })) + " ([4, 0])");
    }

    private static void test4() {
        System.out.println(Arrays.toString(amountPainted(new int[][] {
                new int[] {0, 5},
                new int[] {0, 2},
                new int[] {0, 3},
                new int[] {0, 4},
                new int[] {0, 5}
        })) + " ([5, 0, 0, 0, 0])");
    }

    private static void test5() {
        System.out.println(Arrays.toString(amountPainted(new int[][] {
                new int[] {1, 3},
                new int[] {2, 5},
                new int[] {0, 4},
                new int[] {4, 5}
        })) + " ([2, 2, 1, 0])");
    }

    private static void test6() {
        System.out.println(Arrays.toString(amountPainted(new int[][] {
                new int[] {2, 4},
                new int[] {0, 4},
                new int[] {1, 4},
                new int[] {1, 5},
                new int[] {0, 2}
        })) + " ([2, 2, 0, 1, 0])");
    }

    public static void main(final String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

}
