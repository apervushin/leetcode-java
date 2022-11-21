package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/range-module/
 */
public class RangeModule1 {

    private static class RangeModule {

        private final TreeMap<Integer, Integer> intervals = new TreeMap<>();

        public void addRange(int left, int right) {
            while (true) {
                final var interval = intervals.floorEntry(right);
                if (interval == null || interval.getValue() < left) {
                    break;
                } else {
                    left = Math.min(left, interval.getKey());
                    right = Math.max(right, interval.getValue());
                    intervals.remove(interval.getKey());
                }
            }

            while (true) {
                final var interval = intervals.ceilingEntry(left);
                if (interval == null || right < interval.getKey()) {
                    break;
                } else {
                    left = Math.min(left, interval.getKey());
                    right = Math.max(right, interval.getValue());
                    intervals.remove(interval.getKey());
                }
            }

            intervals.put(left, right);
        }

        public boolean queryRange(final int left, final int right) {
            final var interval = intervals.floorEntry(right);
            if (interval == null) {
                return false;
            }
            return interval.getKey() <= left && interval.getValue() >= right;
        }

        public void removeRange(final int left, final int right) {
            final List<int[]> newIntervals = new ArrayList<>();
            //System.out.println("del: " + left + " " + right);
            while (true) {
                final var interval = intervals.floorEntry(right);
                if (interval == null || interval.getValue() <= left) {
                    break;
                } else {
                    intervals.remove(interval.getKey());
                    if (interval.getValue() > right) {
                        newIntervals.add(new int[] {right, interval.getValue()});
                    }
                    if (interval.getKey() < left) {
                        newIntervals.add(new int[] {interval.getKey(), left});
                        break;
                    }
                }
            }

            while (true) {
                final var interval = intervals.ceilingEntry(left);
                if (interval == null || right <= interval.getKey()) {
                    break;
                } else {
                    intervals.remove(interval.getKey());
                    if (right <= interval.getValue()) {
                        newIntervals.add(new int[] {right, interval.getValue()});
                        break;
                    }
                }
            }

            for (final var newInterval : newIntervals) {
                intervals.put(newInterval[0], newInterval[1]);
            }
            //System.out.println(intervals);
        }
    }

    private static void test1() {
        final var solution = new RangeModule();
        solution.addRange(10, 20);
        solution.removeRange(14, 16);
        System.out.println(solution.queryRange(10, 14));
        System.out.println(solution.queryRange(13, 15));
        System.out.println(solution.queryRange(16, 17));
    }

    private static void test2() {
        final var solution = new RangeModule();
        solution.addRange(5,8);
        System.out.println(solution.queryRange(3,4) + " (false)");
        solution.removeRange(5,6);
        solution.removeRange(3,6);
        solution.addRange(1,3);
        System.out.println(solution.queryRange(2,3));
        solution.addRange(4,8);
        System.out.println(solution.queryRange(2,3));
        solution.removeRange(4,9);
    }

    private static void test3() {
        final var solution = new RangeModule();
        System.out.println(solution.queryRange(21,34) + " (false)");
        System.out.println(solution.queryRange(27,87) + " (false)");
        solution.addRange(44,53);
        solution.addRange(69,89);
        System.out.println(solution.queryRange(23,26) + " (false)");
        System.out.println(solution.queryRange(80,84) + " (true)");
        System.out.println(solution.queryRange(11,12) + " (false)");
        solution.removeRange(86,91);
        solution.addRange(87,94);
        solution.removeRange(34,52);
        solution.addRange(1,59);
        solution.removeRange(62,96);
        solution.removeRange(34,83);
        System.out.println(solution.queryRange(11,59) + " (false)");
        System.out.println(solution.queryRange(59,79) + " (false)");
        System.out.println(solution.queryRange(1,13) + " (true)");
        System.out.println(solution.queryRange(21,23) + " (true)");
        solution.removeRange(9,61);
        solution.addRange(17,21);
        solution.removeRange(4,8);
        System.out.println(solution.queryRange(19,25) + " (false)");
        solution.addRange(71,98);
        solution.addRange(23,94);
        solution.removeRange(58,95);
        System.out.println(solution.queryRange(12,78) + " (false)");
        solution.removeRange(46,47);
        solution.removeRange(50,70);
        solution.removeRange(84,91);
        solution.addRange(51,63);
        solution.removeRange(26,64);
        solution.addRange(38,87);
        System.out.println(solution.queryRange(41,84) + " (true)");
        System.out.println(solution.queryRange(19,21) + " (true)");
        System.out.println(solution.queryRange(18,56) + " (false)");
        System.out.println(solution.queryRange(23,39) + " (false)");
        System.out.println(solution.queryRange(29,95) + " (false)");
        solution.addRange(79,100);
        solution.removeRange(76,82);
        solution.addRange(37,55);
        solution.addRange(30,97);
        solution.addRange(1,36);
        System.out.println(solution.queryRange(18,96) + " (true)");
        solution.removeRange(45,86);
        solution.addRange(74,92);
        System.out.println(solution.queryRange(27,78) + " (false)");
        solution.addRange(31,35);
        System.out.println(solution.queryRange(87,91) + " (true)");
        solution.removeRange(37,84);
        solution.removeRange(26,57);
        solution.addRange(65,87);
        solution.addRange(76,91);
        System.out.println(solution.queryRange(37,77) + " (false)");
        System.out.println(solution.queryRange(18,66) + " (false)");
        solution.addRange(22,97);
        solution.addRange(2,91);
        solution.removeRange(82,98);
        solution.removeRange(41,46);
        solution.removeRange(6,78);
        System.out.println(solution.queryRange(44,80) + " (false)");
        solution.removeRange(90,94);
        solution.removeRange(37,88);
        solution.addRange(75,90);
        solution.removeRange(18,80);
        solution.addRange(92,93);
        solution.addRange(3,80);
        System.out.println(solution.queryRange(68,86) + " (true)");
        solution.removeRange(68,92);
        System.out.println(solution.queryRange(52,91) + " (false)");
        solution.addRange(43,53);
        solution.addRange(36,37);
        solution.addRange(60,74);
        solution.addRange(4,9);
        solution.addRange(44,80);
        solution.removeRange(85,93);
        solution.removeRange(56,83);
        solution.addRange(9,26);
        System.out.println(solution.queryRange(59,64) + " (false)");
        System.out.println(solution.queryRange(16,66) + " (false)");
        solution.removeRange(29,36);
        solution.removeRange(51,96);
        solution.removeRange(56,80);
        solution.addRange(13,87);
        System.out.println(solution.queryRange(42,72) + " (true)");
        solution.removeRange(6,56);
        System.out.println(solution.queryRange(24,53) + " (false)");
        solution.addRange(43,71);
        solution.removeRange(36,83);
        solution.removeRange(15,45);
        System.out.println(solution.queryRange(10,48) + " (false)");
    }

    public static void main(final String[] args) {
        test1();
        test2();
        test3();
    }

}
