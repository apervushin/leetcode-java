package in.pervush.leetcode.problems;

import in.pervush.leetcode.utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings/
 */
public class SumOfPrefixScoresOfStrings {

    private static final int ALPHABET_SIZE = 26;
    private static class TrieNode {
        int score;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    }

    public static int[] sumPrefixScores(final String[] words) {
        final var trie = buildTrie(words);
        final int[] result = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            result[i] = countPrefixes(trie, words[i]);
        }
        return result;
    }

    private static int countPrefixes(final TrieNode root, final String word) {
        TrieNode current = root;
        int result = 0;
        for (int i = 0; i < word.length(); ++i) {
            final int c = (int) word.charAt(i) - 'a';
            current = current.children[c];
            result += current.score;
        }
        return result;
    }

    private static TrieNode buildTrie(final String[] words) {
        final String[] wordsSorted = new String[words.length];
        System.arraycopy(words, 0, wordsSorted, 0, words.length);
        Arrays.sort(wordsSorted, Comparator.comparingInt(String::length));

        final TrieNode root = new TrieNode();
        for (final String word : words) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); ++i) {
                final int c = (int) word.charAt(i) - 'a';
                if (current.children[c] == null) {
                    current.children[c] = new TrieNode();
                }
                current = current.children[c];
                ++current.score;
            }
        }

        return root;
    }

    public static void main(final String[] args) {
        PrintUtils.print(sumPrefixScores(new String[]{"abc", "ab", "bc", "b"}));
        PrintUtils.print(sumPrefixScores(new String[]{"abcd"}));
    }
}
