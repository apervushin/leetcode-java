package in.pervush.leetcode.problems;

import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphValidTree {

    public static boolean validTree(final int n, final int[][] edges) {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        final BitSet visited = new BitSet(n);

        for(final var edge : edges) {
            addEdge(graph, edge[0], edge[1]);
            addEdge(graph, edge[1], edge[0]);
        }

        return validTree(0, graph, visited) && visited.cardinality() == n;
    }

    private static boolean validTree(final int node, final Map<Integer, Set<Integer>> graph, final BitSet visited) {
        if (visited.get(node)) {
            return false;
        }
        visited.set(node);
        final var iterator = graph.getOrDefault(node, Collections.emptySet()).iterator();
        while (iterator.hasNext()) {
            final var edge = iterator.next();
            iterator.remove();
            graph.get(edge).remove(node);
            if (!validTree(edge, graph, visited)) {
                return false;
            }
        }
        return true;
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
