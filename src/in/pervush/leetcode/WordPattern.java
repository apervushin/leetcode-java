package in.pervush.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        final String[] sWords = s.split(" ");
        if (pattern.length() != sWords.length) {
            return false;
        }
        Map<Character, String> mapping = new HashMap<>();
        Map<String, Character> mappingReversed = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            String word = sWords[i];

            var prevWord = mapping.put(c, word);
            if (prevWord != null && !prevWord.equals(word)) {
                return false;
            }
            var prevChar = mappingReversed.put(word, c);
            if (prevChar != null && !prevChar.equals(c)) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern solution = new WordPattern();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }

}
