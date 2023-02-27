package in.pervush.leetcode.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary {

    public static String alienOrder(final String[] words) {
        try {
            final var graph = buildGraph(words);
            final Map<Character, Integer> visitedNodes = new HashMap<>(); // node -> exit time
            final var counter = new AtomicInteger();

            for (final var node : graph.keySet()) {
                if (!visitedNodes.containsKey(node)) {
                    dfs(graph, visitedNodes, node, counter);
                }
            }

            //System.out.println(visitedNodes);
            return visitedNodes.entrySet().stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .map(Map.Entry::getKey)
                    .map(Object::toString)
                    .collect(Collectors.joining(""));
        } catch (IllegalStateException ex) {
            return "";
        }
    }

    private static void dfs(final Map<Character, Set<Character>> graph, final Map<Character, Integer> visitedNodes,
                            final char node, final AtomicInteger counter) throws IllegalStateException {
        //System.out.println(node);
        final var exitValue = visitedNodes.get(node);
        if (Integer.valueOf(-1).equals(exitValue)) {
            throw new IllegalStateException("Cycle detected");
        }
        if (exitValue != null) {
            return;
        }
        visitedNodes.put(node, -1);

        for (final Character neighbour : graph.getOrDefault(node, Collections.emptySet())) {
            dfs(graph, visitedNodes, neighbour, counter);
        }

        visitedNodes.put(node, counter.getAndIncrement());
    }

    private static Map<Character, Set<Character>> buildGraph(final String[] words) {
        final Map<Character, Set<Character>> graph = new HashMap<>();

        words[0].chars().forEach(c -> graph.putIfAbsent((char)c, new HashSet<>()));

        for (int i = 1; i < words.length; ++i) {
            words[i].chars().forEach(c -> graph.putIfAbsent((char)c, new HashSet<>()));
            buildGraph(words[i - 1], words[i], 0, graph);
        }

        //System.out.println(graph);
        return graph;
    }

    private static void buildGraph(final String word1, final String word2, final int charPos,
                                   final Map<Character, Set<Character>> graph) {
        if (word1.length() == charPos || word2.length() == charPos) {
            if (word1.length() > word2.length()) {
                throw new IllegalStateException("Invalid order");
            }
            return;
        }
        final char a = word1.charAt(charPos);
        final char b = word2.charAt(charPos);
        if (a != b) {
            graph.compute(a, (k, v) -> {
                if (v == null) {
                    v = new HashSet<>();
                }
                v.add(b);
                return v;
            });
        } else {
            buildGraph(word1, word2, charPos + 1, graph);
        }
    }

    public static void main(final String[] args) {
        System.out.println(alienOrder(new String[] {"wrt","wrf","er","ett","rftt"}) + " (wertf)");
        System.out.println(alienOrder(new String[] {"z","x"}) + " (zx)");
        System.out.println(alienOrder(new String[] {"z","x","z"}) + " (_)");
        System.out.println(alienOrder(new String[] {"zy","zx"}) + " (zyx, yxz, yzx)");
        System.out.println(alienOrder(new String[] {"ab","adc"}) + " (acbd, cabd, abdc, cbda, bdac, bdca)");
        System.out.println(alienOrder(new String[] {"a","b","ca","cc"}) + " (abc)");
        System.out.println(alienOrder(new String[] {"abc","ab"}) + " (_)");
    }
}
