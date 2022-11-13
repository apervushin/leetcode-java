package in.pervush.leetcode.problems;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-i/
 */
public class MyCalendarI {

    private static class MyCalendar {

        private final TreeMap<Integer, Integer> intervals = new TreeMap<>();

        public boolean book(final int start, final int end) {
            var entry = intervals.floorEntry(end - 1);
            //System.out.println(start + " " + end + " " + intervals + " " + entry);
            if (entry == null || entry.getKey() >= end || entry.getValue() <= start) {
                intervals.put(start, end);
                return true;
            }
            return false;
        }
    }

    private static void test1() {
        System.out.println();
        final var solution = new MyCalendar();
        System.out.println(solution.book(10, 20));
        System.out.println(solution.book(15, 25));
        System.out.println(solution.book(20, 30));
    }

    private static void test2() {
        System.out.println();
        final var solution = new MyCalendar();
        System.out.println(solution.book(47,50) + " (true)");
        System.out.println(solution.book(33,41) + " (true)");
        System.out.println(solution.book(39,45) + " (false)");
        System.out.println(solution.book(33,42) + " (false)");
        System.out.println(solution.book(25,32) + " (true)");
        System.out.println(solution.book(26,35) + " (false)");
        System.out.println(solution.book(19,25) + " (true)");
        System.out.println(solution.book(3,8) + " (true)");
        System.out.println(solution.book(8,13) + " (true)");
        System.out.println(solution.book(18,27) + " (false)");
    }

    private static void test3() {
        System.out.println();
        final var solution = new MyCalendar();
        System.out.println(solution.book(20,29) + " (true)");
        System.out.println(solution.book(13,22) + " (false)");
        System.out.println(solution.book(44,50) + " (true)");
        System.out.println(solution.book(1,7) + " (true)");
        System.out.println(solution.book(2,10) + " (false)");
        System.out.println(solution.book(14,20) + " (true)");
        System.out.println(solution.book(19,25) + " (false)");
        System.out.println(solution.book(36,42) + " (true)");
        System.out.println(solution.book(45,50) + " (false)");
        System.out.println(solution.book(47,50) + " (false)");
        System.out.println(solution.book(39,45) + " (false)");
        System.out.println(solution.book(44,50) + " (false)");
        System.out.println(solution.book(16,25) + " (false)");
        System.out.println(solution.book(45,50) + " (false)");
        System.out.println(solution.book(45,50) + " (false)");
        System.out.println(solution.book(12,20) + " (false)");
        System.out.println(solution.book(21,29) + " (false)");
        System.out.println(solution.book(11,20) + " (false)");
        System.out.println(solution.book(12,17) + " (false)");
        System.out.println(solution.book(34,40) + " (false)");
        System.out.println(solution.book(10,18) + " (false)");
        System.out.println(solution.book(38,44) + " (false)");
        System.out.println(solution.book(23,32) + " (false)");
        System.out.println(solution.book(38,44) + " (false)");
        System.out.println(solution.book(15,20) + " (false)");
        System.out.println(solution.book(27,33) + " (false)");
        System.out.println(solution.book(34,42) + " (false)");
        System.out.println(solution.book(44,50) + " (false)");
        System.out.println(solution.book(35,40) + " (false)");
        System.out.println(solution.book(24,31) + " (false)");
    }


    public static void main(final String[] args) {
        test1();
        test2();
        test3();
    }

}
