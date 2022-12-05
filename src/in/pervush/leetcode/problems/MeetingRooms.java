package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms {

    public static boolean canAttendMeetings(final int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; ++i) {
            if (isIntersect(intervals[i - 1], intervals[i])) {
                return false;
            }
        }

        return true;
    }

    private static boolean isIntersect(final int[] a, final int[] b) {
        return (a[0] <= b[0] && a[1] > b[0]) || (b[0] <= a[0] && b[1] > a[0]);
    }

    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][] {{0,30}, {5,10}, {15,20}}) + " (false)");
        System.out.println(canAttendMeetings(new int[][] {{7,10}, {2,4}}) + " (true)");
        System.out.println(canAttendMeetings(new int[][] {{1,13}, {13,15}}) + " (true)");
    }
}
