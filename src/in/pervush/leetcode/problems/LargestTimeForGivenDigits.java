package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-time-for-given-digits/
 */
public class LargestTimeForGivenDigits {

    public static String largestTimeFromDigits(final int[] arr) {
        final String input = String.valueOf(arr[0]) + arr[1] + arr[2] + arr[3];
        List<String> validPermutations = new ArrayList<>();

        generateValidPermutations("", input, validPermutations);
        if (validPermutations.isEmpty()) {
            return "";
        }
        validPermutations.sort(Comparator.reverseOrder());
        final String maxPermutation = validPermutations.get(0);

        return maxPermutation.substring(0, 2) + ":" + maxPermutation.substring(2);
    }

    private static void generateValidPermutations(final String prefix, final String str, final List<String> result) {
        if (str.length() == 0) {
            if (isValid(prefix)) {
                result.add(prefix);
            }
            return;
        }
        for (int i = 0; i < str.length(); ++i) {
            generateValidPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), result);
        }
    }

    private static boolean isValid(final String str) {
        return str.substring(0, 2).compareTo("24") < 0 && str.substring(2).compareTo("60") < 0;
    }

    public static void main(final String[] args) {
        System.out.println(largestTimeFromDigits(new int[] {1, 2, 3, 4}));
        System.out.println(largestTimeFromDigits(new int[] {5, 5, 5, 5}));
        System.out.println(largestTimeFromDigits(new int[] {0, 0, 0, 0}));
        System.out.println(largestTimeFromDigits(new int[] {2, 0, 6, 6}));
    }
}
