package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/shortest-way-to-form-string/solutions/
 *
 * Interview follow ups:
 * https://leetcode.com/problems/shortest-way-to-form-string/solutions/330938/accept-is-not-enough-to-get-a-hire-interviewee-4-follow-up/
 */
public class ShortestWayToFormString {

    public static int shortestWay(final String source, final String target) {
        final var dct = buildIndex(source);

        int sPos = 0;
        int result = 1;
        for (int i = 0; i < target.length(); ++i) {
            final char c = target.charAt(i);
            final var positions = dct.get(c - 'a');
            if (positions.isEmpty()) {
                return -1;
            }
            int pos = Collections.binarySearch(positions, sPos);
            if (pos < 0) {
                pos = pos * -1 - 1;
            }
            if (pos < positions.size()) {
                sPos = positions.get(pos) + 1;
            } else {
                sPos = positions.get(0) + 1;
                result++;
            }
        }

        return result;
    }

    public static List<List<Integer>> buildIndex(final String s) {
        final List<List<Integer>> dct = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            dct.add(new ArrayList<>());
        }
        for (int i = 0 ; i < s.length(); ++i) {
            dct.get(s.charAt(i) - 'a').add(i);
        }
        return dct;
    }


    public static void main(final String[] args) {
        System.out.println(shortestWay("abc", "abcbc") + " (2)");
        System.out.println(shortestWay("abc", "acdbc") + " (-1)");
        System.out.println(shortestWay("xyz", "xzyxz") + " (3)");
        System.out.println(shortestWay("abc", "abcabcd") + " (-1)");
        System.out.println(shortestWay("aaaaa", "aaaaaaaaaaaaa") + " (3)");
        System.out.println(shortestWay("aa", "aaa") + " (2)");
    }
}
