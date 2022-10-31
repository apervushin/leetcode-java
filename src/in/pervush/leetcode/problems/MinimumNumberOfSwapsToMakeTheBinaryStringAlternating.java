package in.pervush.leetcode.problems;

public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {

    public static int minSwaps(final String s) {
        final int[] charsCounts = new int[2];
        for (int i = 0; i < s.length(); ++i) {
            charsCounts[s.charAt(i) - '0']++;
        }

        char[] chars = new char[s.length()];
        int result = Integer.MAX_VALUE;
        if (charsCounts[0] > 0) {
            charsCounts[0]--;
            chars[0] = '0';
            result = minSwaps(s, charsCounts, 1, chars);
            charsCounts[0]++;
        }
        if (charsCounts[1] > 0) {
            charsCounts[1]--;
            chars[0] = '1';
            result = Math.min(result, minSwaps(s, charsCounts, 1, chars));
            charsCounts[1]++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int minSwaps(final String s, final int[] charsCounts, final int pos, final char[] chars) {
        if (pos == s.length()) {
            return countDiffChars(s, chars);
        }

        int result = Integer.MAX_VALUE;
        char prev = chars[pos - 1];

        if (prev == '0') {
            if (charsCounts[1] == 0) {
                return Integer.MAX_VALUE;
            }
            charsCounts[1]--;
            chars[pos] = '1';
            result = Math.min(result, minSwaps(s, charsCounts, pos + 1, chars));
            charsCounts[1]++;
        }

        if (prev == '1') {
            if (charsCounts[0] == 0) {
                return Integer.MAX_VALUE;
            }
            charsCounts[0]--;
            chars[pos] = '0';
            result = Math.min(result, minSwaps(s, charsCounts, pos + 1, chars));
            charsCounts[0]++;
        }

        return result;
    }

    private static int countDiffChars(final String s1, final char[] s2) {
//        System.out.println(Arrays.toString(s1.toCharArray()));
//        System.out.println(Arrays.toString(s2));

        int result = 0;
        for (int i = 0; i < s2.length; ++i) {
            if (s1.charAt(i) != s2[i]) {
                ++result;
            }
        }
//        System.out.println(result);
        return result / 2;
    }

    public static void main(final String[] args) {
        System.out.println(minSwaps("111000") + " (1)");
        System.out.println(minSwaps("010") + " (0)");
        System.out.println(minSwaps("1110") + " (-1)");
        System.out.println(minSwaps("0") + " (0)");
        System.out.println(minSwaps("1") + " (0)");
        System.out.println(minSwaps("01") + " (0)");
    }
}
