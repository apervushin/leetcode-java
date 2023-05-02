package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    public List<List<String>> partition(final String s) {
        final List<List<String>> result = new ArrayList<>();
        partition(s, 0, result, new ArrayList<>());
        return result;
    }

    private void partition(final String s, final int pos, final List<List<String>> result,
                           final List<String> currentResult) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(currentResult));
        }
        for (int i = pos; i < s.length(); ++i) {
            if (isPalindrome(s, pos, i)) {
                currentResult.add(s.substring(pos, i + 1));
                partition(s, i + 1, result, currentResult);
                currentResult.remove(currentResult.size() - 1);
            }
        }
    }

    private boolean isPalindrome(final String s, final int startPos, final int endPos) {
        for (int i = startPos; i < startPos + ((endPos - startPos + 1) / 2); ++i) {
            if (s.charAt(i) != s.charAt(endPos - i + startPos)) {
                return false;
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        final var solution = new PalindromePartitioning();
        System.out.println(solution.partition("aaa"));
    }
}
