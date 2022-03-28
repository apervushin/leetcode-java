package in.pervush.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> replacement = new HashMap<>();
        Map<Character, Character> replacementReversed = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            final char sChar = s.charAt(i);
            final char tChar = t.charAt(i);

            final Character prevTChar = replacement.put(sChar, tChar);
            if (prevTChar != null && !prevTChar.equals(tChar)) {
                return false;
            }
            final Character prevSChar = replacementReversed.put(tChar, sChar);
            if (prevSChar != null && !prevSChar.equals(sChar)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("badc", "baba"));

    }
}
