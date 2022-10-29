package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-keypresses/
 */
public class MinimumNumberOfKeypresses {

    public static int minimumKeypresses(final String s) {
        final int[] charsCount = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            final int j = s.charAt(i) - 'a';
            charsCount[j]++;
        }

        Arrays.sort(charsCount);

        int result = 0;
        for (int i = charsCount.length - 1; i >= 0; --i) {
            final var cnt = charsCount[i];
            if (i > charsCount.length - 9 - 1) {
                result += cnt;
            } else if (i > charsCount.length - 18 - 1) {
                result += cnt * 2;
            } else {
                result += cnt * 3;
            }
        }

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(minimumKeypresses("apple") + " (5)");
        System.out.println(minimumKeypresses("abcdefghijkl") + " (15)");
    }
}
