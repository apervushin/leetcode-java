package in.pervush.leetcode.problems;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-number-of-visible-points/
 * Explanation: https://www.youtube.com/watch?v=tq4PT40VVfQ&t=2s
 */
public class MaximumNumberOfVisiblePoints {

    public static int visiblePoints(final List<List<Integer>> points, final int angle, final List<Integer> location) {
        final List<Double> angles = new ArrayList<>();
        int locationPoints = 0; // Number of points with the same x,y as location's x,y
        for (final var point : points) {
            if (point.get(0).equals(location.get(0)) && point.get(1).equals(location.get(1))) {
                ++locationPoints;
                continue;
            }
            angles.add(getAngle(point.get(0), point.get(1), location.get(0), location.get(1)));
        }
        Collections.sort(angles);

        // Add extra points to solve 360 and 1 angles
        final List<Double> anglesToAdd = new ArrayList<>();
        for (double a : angles) {
            if (a > angle) {
                break;
            }
            anglesToAdd.add(a + 360);
        }
        angles.addAll(anglesToAdd);

        int startPos = 0;
        int maxCount = 0;
        for (int i = 0; i < angles.size(); ++i) {
            while (startPos < i && angles.get(startPos) + angle < angles.get(i)) {
                ++startPos;
            }
            System.out.println(startPos + " - " + i);
            maxCount = Math.max(maxCount, i - startPos + 1);
        }

        //System.out.println(angles);

        return locationPoints + maxCount;
    }

    private static double getAngle(final int x, final int y, final int originX, final int originY) {
        double angle = Math.atan2(y - originY, x - originX) * 180 / Math.PI;
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    private static void test1() {
        System.out.println(visiblePoints(
                List.of(
                        List.of(2,1),
                        List.of(2,2),
                        List.of(3,3)
                ),
                90,
                List.of(1,1)
        ) + " (3)");
    }

    private static void test2() {
        System.out.println(visiblePoints(
                List.of(
                        List.of(2,1),
                        List.of(2,2),
                        List.of(3,4),
                        List.of(1,1)
                ),
                90,
                List.of(1,1)
        ) + " (4)");
    }

    private static void test3() {
        System.out.println(visiblePoints(
                List.of(
                        List.of(1,0),
                        List.of(2,1)
                ),
                13,
                List.of(1,1)
        ) + " (1)");
    }

    public static void main(final String[] args) {
        test1();
        test2();
        test3();
    }
}
