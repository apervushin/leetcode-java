package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public static List<List<Integer>> allPathsSourceTarget(final int[][] graph) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> currentPath = new ArrayList<>();

        dfs(graph, result, currentPath, 0, graph.length - 1);

        return result;
    }

    public static void dfs(final int[][] graph, final List<List<Integer>> result, final List<Integer> currentPath,
                           final int start, final int destination) {
        currentPath.add(start);

        if (start == destination) {
            result.add(new ArrayList<>(currentPath));
        } else {
            for (final int neighbour : graph[start]) {
                dfs(graph, result, currentPath, neighbour, destination);
            }
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
