package in.pervush.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindAndReplaceInString {

    public static String findReplaceString(final String s, final int[] indices, final String[] sources,
                                           final String[] targets) {
        final PriorityQueue<int[]> indicesQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < indices.length; ++i) {
            indicesQueue.add(new int[] {indices[i], i});
        }

        final StringBuilder result = new StringBuilder();

        int pos = 0;
        while (!indicesQueue.isEmpty()) {
            final var poll = indicesQueue.poll();
            final int replacePos = poll[0];
            final int replaceIndexPos = poll[1];

            while (pos < replacePos) {
                result.append(s.charAt(pos++));
            }

            if (!s.startsWith(sources[replaceIndexPos], pos)) {
                continue;
            }

            pos += sources[replaceIndexPos].length();

            result.append(targets[replaceIndexPos]);
        }

        while (pos < s.length()) {
            result.append(s.charAt(pos++));
        }

        return result.toString();
    }

    public static void main(final String[] args) {
        System.out.println(findReplaceString(
                "abcd",
                new int[] {0, 2},
                new String[] {"a", "cd"},
                new String[] {"eee", "ffff"}
        ));

        System.out.println(findReplaceString(
                "abcd",
                new int[] {0, 2},
                new String[] {"ab", "ec"},
                new String[] {"eee", "ffff"}
        ));

        System.out.println(findReplaceString(
                "abcde",
                new int[] {2, 2},
                new String[] {"cdef", "bc"},
                new String[] {"f", "fe"}
        ));
    }
}
