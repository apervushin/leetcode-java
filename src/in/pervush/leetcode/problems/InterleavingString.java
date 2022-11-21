package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {

    public static boolean isInterleave(final String s1, final String s2, final String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, new byte[s1.length() + 1][s2.length() + 1]);
    }

    public static boolean isInterleave(final String s1, final String s2, final String s3, int s1Pos, int s2Pos,
                                       final byte[][] state) {
        if (s1Pos + s2Pos == s3.length()) {
            return true;
        }
        if (state[s1Pos][s2Pos] != 0) {
            return state[s1Pos][s2Pos] == -1 ? false : true;
        }
        boolean result = false;

        if (s1Pos < s1.length() && s1.charAt(s1Pos) == s3.charAt(s1Pos + s2Pos)) {
            result = isInterleave(s1, s2, s3, s1Pos + 1, s2Pos, state);
        }
        if (!result && s2Pos < s2.length() && s2.charAt(s2Pos) == s3.charAt(s1Pos + s2Pos)) {
            result = isInterleave(s1, s2, s3, s1Pos, s2Pos + 1, state);
        }

        state[s1Pos][s2Pos] = (byte)(result ? 1 : -1);

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("", "", ""));
        System.out.println(isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
