package in.pervush.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/buddy-strings/
 */
public class BuddyStrings {

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        boolean containsSameChars = false;
        boolean swapped = false;
        int firstNotEqualPos = -1;
        Set<Character> chars = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char goalChar = goal.charAt(i);

            if (!containsSameChars && chars.contains(sChar)) {
                containsSameChars = true;
            }
            chars.add(sChar);

            if (sChar == goalChar) {
                continue;
            }
            if(swapped) {
                return false;
            }
            if (firstNotEqualPos == -1) {
                firstNotEqualPos = i;
                continue;
            }
            if (s.charAt(firstNotEqualPos) == goalChar && goal.charAt(firstNotEqualPos) == sChar) {
                swapped = true;
                continue;
            }
            return false;
        }

        return swapped || (containsSameChars && firstNotEqualPos == -1);
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("aaabc", "aaacb"));
        System.out.println(buddyStrings("abac", "abad"));
    }

}
