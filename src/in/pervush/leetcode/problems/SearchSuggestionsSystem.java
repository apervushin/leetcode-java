package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionsSystem {

    private static final int SEARCH_LIMIT = 3;
    private static class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        boolean isWord;
        String word;

        final char c;

        public TrieNode(final boolean isWord, final String word, final char c) {
            this.isWord = isWord;
            this.word = word;
            this.c = c;
        }

        public void setWord(boolean isWord, final String word) {
            this.isWord = isWord || this.isWord;
            this.word = this.word != null ? this.word : word;
        }

        @Override
        public String toString() {
            return "{" + Arrays.toString(children) + "," + isWord + '}';
        }
    }

    public static List<List<String>> suggestedProducts(final String[] products, final String searchWord) {
        var trie = buildTrie(products);
        final List<List<String>> result = new ArrayList<>(searchWord.length());

        for (int i = 0; i < searchWord.length(); ++i) {
            if (trie == null) {
                result.add(Collections.emptyList());
                continue;
            }
            final List<String> resultItem = new ArrayList<>();
            final char c = searchWord.charAt(i);
            final var child = trie.children[c - 'a'];
            fillResultItem(resultItem, child);
            trie = child;
            result.add(resultItem);
        }

        return result;
    }

    private static void fillResultItem(final List<String> resultItem, final TrieNode root) {
        if (root == null) {
            return;
        }
        if (resultItem.size() == SEARCH_LIMIT) {
            return;
        }
        if (root.isWord) {
            resultItem.add(root.word);
        }
        for (final var node : root.children) {
            fillResultItem(resultItem, node);
        }
    }

    private static TrieNode buildTrie(final String[] products) {
        final var root = new TrieNode(false, null, ' ');
        for (final String product : products) {
            var currentNode = root;
            for (int i = 0; i < product.length(); ++i) {
                final char c = product.charAt(i);
                final boolean isWord = product.length() == i + 1;
                if (currentNode.children[c - 'a'] == null) {
                    currentNode.children[c - 'a'] = new TrieNode(isWord, isWord ? product : null, c);
                } else {
                    currentNode.children[c - 'a'].setWord(isWord, isWord ? product : null);
                }

                currentNode = currentNode.children[c - 'a'];

            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(suggestedProducts(
                new String[] {"mobile","mouse","moneypot","monitor","mousepad"},
                "mouse"
        ));
        System.out.println(suggestedProducts(
                new String[] {"havana"},
                "havana"
        ));
        System.out.println(suggestedProducts(
                new String[] {"havana"},
                "tatiana"
        ));
    }

}
