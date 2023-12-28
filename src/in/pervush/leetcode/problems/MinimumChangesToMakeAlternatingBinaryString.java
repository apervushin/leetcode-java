package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 */
public class MinimumChangesToMakeAlternatingBinaryString {

    public static int minOperations(final String s) {
        return Math.min(minOperations(s, '0', '1'), minOperations(s, '1', '0'));
    }

    public static int minOperations(final String s, char char1, char char2) {
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != char1) {
                result++;
            }
            char tmp = char1;
            char1 = char2;
            char2 = tmp;
        }

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(minOperations("0100") + "(1)");
        System.out.println(minOperations("10") + "(0)");
        System.out.println(minOperations("1111") + "(2)");
    }
}
