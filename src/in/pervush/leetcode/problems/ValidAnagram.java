package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sState = new int[26];
        int[] tState = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            sState[s.charAt(i) - 'a']++;
            tState[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < sState.length; ++i) {
            if (sState[i] != tState[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var solution = new ValidAnagram();
        System.out.println(solution.isAnagram("", ""));
        System.out.println(solution.isAnagram("aaab", "baaa"));
        System.out.println(solution.isAnagram("aaab", "bbaa"));
    }

}
