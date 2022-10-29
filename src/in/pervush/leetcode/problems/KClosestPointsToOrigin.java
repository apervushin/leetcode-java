package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        return Arrays.stream(points)
                .sorted(Comparator.comparingInt(a -> getDistancePos2(a[0], a[1])))
                .limit(k)
                .toArray(int[][]::new);
    }

    private static int getDistancePos2(final int x, final int y) {
        return (x * x) + (y * y);
    }

    public static void main(String[] args) {
        final var result = kClosest(
                new int[][]{
                        new int[]{1, 3},
                        new int[]{-2, 2},
                },
                1
        );
        for (final var r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}
