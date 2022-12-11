package in.pervush.leetcode.problems;

import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public static int countComponents(final int n, final int[][] edges) {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        final BitSet visited = new BitSet(n);

        for(final var edge : edges) {
            addEdge(graph, edge[0], edge[1]);
            addEdge(graph, edge[1], edge[0]);
        }

        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (visited.get(i)) {
                continue;
            }
            ++result;

            final Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                final var node = queue.poll();

                for (final Integer edge : graph.getOrDefault(node, Collections.emptySet())) {
                    if (visited.get(edge)) {
                        continue;
                    }
                    visited.set(edge);
                    queue.add(edge);
                }
            }
        }

        return result;
    }

    private static void addEdge(final Map<Integer, Set<Integer>> graph, final int from, final int to) {
        graph.compute(from, (k, v) -> {
            if (v == null) {
                v = new HashSet<>();
            }
            v.add(to);
            return v;
        });
    }

}
