package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        final List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == end + 1) {
                end = nums[i];
                continue;
            }
            result.add(buildIntervalString(start, end));
            start = nums[i];
            end = nums[i];
        }
        result.add(buildIntervalString(start, end));
        return result;
    }

    private static String buildIntervalString(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return start + "->" + end;
    }

    private static void test1() {
        int[] input = {0,1,2,3,4,5};
        System.out.println(Arrays.toString(input));
        System.out.println(summaryRanges(input));
        System.out.println();
    }

    private static void test2() {
        int[] input = {2,3,4,5};
        System.out.println(Arrays.toString(input));
        System.out.println(summaryRanges(input));
        System.out.println();
    }

    private static void test3() {
        int[] input = {0,1,2,4,5,7};
        System.out.println(Arrays.toString(input));
        System.out.println(summaryRanges(input));
        System.out.println();
    }

    private static void test4() {
        int[] input = {};
        System.out.println(Arrays.toString(input));
        System.out.println(summaryRanges(input));
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
