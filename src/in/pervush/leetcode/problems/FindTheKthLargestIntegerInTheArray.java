package in.pervush.leetcode.problems;

import java.util.Arrays;

public class FindTheKthLargestIntegerInTheArray {

    public static String kthLargestNumber(final String[] nums, final int k) {
        Arrays.sort(nums, (a, b) -> {
            final int len = Math.max(a.length(), b.length());
            for (int i = 0; i < len; ++i) {
                final char aVal = i >= len - a.length() ? a.charAt(i) : '0';
                final char bVal = i >= len - b.length() ? b.charAt(i) : '0';
                final int compare = Character.compare(aVal, bVal);
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        });
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new String[] {"3","6","7","10"}, 4) + " (3)");
        System.out.println(kthLargestNumber(new String[] {"2","21","12","1"}, 3) + " (2)");
    }
}
