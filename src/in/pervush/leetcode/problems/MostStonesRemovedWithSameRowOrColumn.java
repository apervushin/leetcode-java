package in.pervush.leetcode.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    public static int removeStones(final int[][] stones) {
        final var graph = buildGraph(stones);
        int result = 0;
        for (int i = 0; i < stones.length; ++i) {
            if (graph.containsKey(i)) {
                dfsRemoveNodes(graph, i);
                ++result;
            }
        }

        return stones.length - result;
    }

    private static void dfsRemoveNodes(final Map<Integer, Set<Integer>> graph, final int node) {
        final var neighbours = graph.remove(node);
        if (neighbours != null) {
            for (final var neighbour : neighbours) {
                dfsRemoveNodes(graph, neighbour);
            }
        }
    }

    private static Map<Integer, Set<Integer>> buildGraph(final int[][] stones) {
        final Map<Integer, Set<Integer>> xToId = new HashMap<>();
        final Map<Integer, Set<Integer>> yToId = new HashMap<>();
        final Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < stones.length; ++i) {
            final int ii = i;

            xToId.compute(stones[i][0], (k, v) -> {
                if (v == null) {
                    v = new HashSet<>();
                }
                v.add(ii);
                return v;
            });

            yToId.compute(stones[i][1], (k, v) -> {
                if (v == null) {
                    v = new HashSet<>();
                }
                v.add(ii);
                return v;
            });

            graph.putIfAbsent(i, new HashSet<>());
        }

        for (int i = 0; i < stones.length; ++i) {
            final int ii = i;

            xToId.getOrDefault(stones[i][0], Collections.emptySet()).stream().filter(v -> !v.equals(ii)).forEach(v -> {
                graph.get(ii).add(v);
                graph.get(v).add(ii);
            });

            yToId.getOrDefault(stones[i][1], Collections.emptySet()).stream().filter(v -> !v.equals(ii)).forEach(v -> {
                graph.get(ii).add(v);
                graph.get(v).add(ii);
            });
        }

        return graph;
    }

    public static void main(final String[] args) {
        System.out.println(removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}) + "(5)");
        System.out.println(removeStones(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}) + "(3)");
        System.out.println(removeStones(new int[][]{{0,0}}) + "(0)");
        System.out.println(removeStones(new int[][]{{0,1},{1,2},{1,3},{3,3},{2,3},{0,2}}) + "(5)");
        System.out.println(removeStones(new int[][]{{5,9},{9,0},{0,0},{7,0},{4,3},{8,5},{5,8},{1,1},{0,6},{7,5},{1,6},{1,9},{9,4},{2,8},{1,3},{4,2},{2,5},{4,1},{0,2},{6,5}}) + "(19?)");
        System.out.println(removeStones(new int[][]{{6,9},{1,3},{8,0},{8,9},{5,1},{7,2},{4,0},{1,2},{4,4},{1,5},{5,3},{9,7},{3,2},{0,0},{8,2},{9,3},{0,5},{3,5},{9,9},{3,8},{4,3},{0,2}}) + "(21?)");
    }
}
