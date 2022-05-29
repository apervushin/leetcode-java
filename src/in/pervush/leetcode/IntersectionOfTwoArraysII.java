package in.pervush.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/?currentPage=1&orderBy=hot&query=
 */
public class IntersectionOfTwoArraysII {

    private static final int MAX_VALUE = 1000;

    public static int[] intersect(int[] nums1, int[] nums2) {
        final List<Integer> result = new ArrayList<>();
        final int[] state = new int[MAX_VALUE + 1];

        for (int n : nums1) {
            ++state[n];
        }

        for (int n : nums2) {
            if (state[n] > 0) {
                --state[n];
                result.add(n);
            }
        }

        return result.stream().mapToInt(v -> v).toArray();
    }

}
