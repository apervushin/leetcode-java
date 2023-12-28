package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reward-top-k-students/
 */
public class RewardTopKStudents {

    private record StudentResult (int studentId, int score) {}

    private static class TrieNode {
        public Boolean positive;
        private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private static final int ALPHABET_SIZE = 26;

        public TrieNode getChild(final char c) {
            return children[c - 'a'];
        }

        public TrieNode setChild(final char c, Boolean positive) {
            final int index = c - 'a';
            if (children[index] == null) {
                children[index] = new TrieNode();
            }
            if (children[index].positive == null) {
                children[index].positive = positive;
            }
            return children[index];
        }

    }

    public static List<Integer> topStudents(final String[] positiveFeedback, final String[] negativeFeedback,
                                     final String[] report, final int[] studentId, int k) {
        final var trie = buildTrie(positiveFeedback,  negativeFeedback);
        final PriorityQueue<StudentResult> queue = new PriorityQueue<>((a,b) -> {
            int compare = Integer.compare(a.score, b.score);
            return compare == 0 ? Integer.compare(b.studentId, a.studentId) : compare;
        });

        for (int i = 0; i < report.length; ++i) {
            final int score = getScore(report[i], trie);
            queue.add(new StudentResult(studentId[i], score));
            while (queue.size() > k) {
                queue.poll();
            }
        }

        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && !queue.isEmpty(); ++i) {
            result.add(queue.poll().studentId);
        }
        Collections.reverse(result);

        return result;
    }

    private static TrieNode buildTrie(final String[] positiveFeedback, final String[] negativeFeedback) {
        final var root = new TrieNode();
        buildTrie(positiveFeedback, root, true);
        buildTrie(negativeFeedback, root, false);
        return root;
    }

    private static void buildTrie(final String[] feedback, final TrieNode root, final boolean positive) {
        for (final var word : feedback) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); ++i) {
                final char c = word.charAt(i);
                current = current.setChild(c, i == word.length() - 1 ? positive : null);
            }
        }
    }

    private static int getScore(final String report, final TrieNode root) {
        int score = 0;
        TrieNode current = root;
        for (int i = 0; i < report.length(); ++i) {
            final char c = report.charAt(i);
            if (c == ' ') {
                if (current != null && current.positive != null) {
                    score += current.positive ? 3 : -1;
                }
                current = root;
            } else if (current != null) {
                current = current.getChild(c);
            }
        }

        if (current != null && current.positive != null) {
            score += current.positive ? 3 : -1;
        }

        return score;
    }

    public static void main(final String[] args) {
        System.out.println(topStudents(
                new String[]{"smart","brilliant","studious"},
                new String[]{"not"},
                new String[]{"this student is not studious","the student is smart"},
                new int[]{1,2},
                2
        ));
    }
}
