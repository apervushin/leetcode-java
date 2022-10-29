package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {

    public static int minMeetingRooms(final int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            final int compare = Integer.compare(a[0], b[0]);
            if (compare == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return compare;
        });

        int result = 0;
        PriorityQueue<Integer> busyRoomsCnt = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; ++i) {
            final var interval = intervals[i];
            final Integer peek = busyRoomsCnt.peek();
            if (peek != null && peek.compareTo(interval[0]) <= 0) {
                busyRoomsCnt.poll();
            }
            busyRoomsCnt.add(interval[1]);

            result = Math.max(busyRoomsCnt.size(), result);
        }

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(minMeetingRooms(new int[][] {
                new int[] {0,30},
                new int[] {5,10},
                new int[] {15,20},
        }));
    }
}
