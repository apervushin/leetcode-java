package in.pervush.leetcode.problems;

import in.pervush.leetcode.utils.Reader;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/meeting-rooms-iii/
 */
public class MeetingRoomsIII {

    public static int mostBooked(final int n, final int[][] meetings) {
        final long[] roomsFreeTime = new long[n];
        final int[] roomsMeetingsCount = new int[n];
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        for (final int[] meeting : meetings) {
            int j, minPos = 0;
            for (j = 0; j < roomsFreeTime.length; ++j) {
                if (roomsFreeTime[j] <= meeting[0]) {
                    break;
                }
                if (roomsFreeTime[minPos] > roomsFreeTime[j]) {
                    minPos = j;
                }
            }

            if (j < roomsFreeTime.length) {
                roomsMeetingsCount[j]++;
                roomsFreeTime[j] = meeting[1];
            } else {
                roomsMeetingsCount[minPos]++;
                roomsFreeTime[minPos] = meeting[1] + (roomsFreeTime[minPos] - meeting[0]);
            }
//            PrintUtils.print(meeting);
//            PrintUtils.print(roomsMeetingsCount);
//            PrintUtils.print(roomsFreeTime);
//            System.out.println();
        }

        int result = 0;
        for (int i = 1; i < roomsMeetingsCount.length; ++i) {
            if (roomsMeetingsCount[result] < roomsMeetingsCount[i]) {
                result = i;
            }
        }

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(mostBooked(2, new int[][] {{0,10},{1,5},{2,7},{3,4}}));
        System.out.println(mostBooked(3, new int[][] {{1,20},{2,10},{3,5},{4,9},{6,8}}));
        System.out.println(mostBooked(10, Reader.read("inputs/2402/1.2.txt")));
    }
}
