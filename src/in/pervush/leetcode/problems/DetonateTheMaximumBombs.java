package in.pervush.leetcode.problems;

import java.util.BitSet;

public class DetonateTheMaximumBombs {

    public static int maximumDetonation(final int[][] bombs) {
        final boolean[][] graph = buildGraph(bombs);
        int maxCount = 0;
        for (int i = 0; i < bombs.length; ++i) {
            final var visited = new BitSet(bombs.length);
            countConnectedNodes(i, graph, visited);
            maxCount = Math.max(maxCount, visited.cardinality());
        }

        return maxCount;
    }

    private static void countConnectedNodes(final int node, final boolean[][] graph, final BitSet visited) {
        if (visited.get(node)) {
            return;
        }
        visited.set(node);
        for (int i = 0; i < graph[node].length; ++i) {
            if (graph[node][i]) {
                countConnectedNodes(i, graph, visited);
            }
        }
    }

    private static boolean[][] buildGraph(final int[][] bombs) {
        final boolean[][] graph = new boolean[bombs.length][bombs.length];

        for (int i = 0; i < bombs.length; ++i) {
            for (int j = i + 1; j < bombs.length; ++j) {
                final double distance = getDistance(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);

                if (bombs[i][2] >= distance) {
                    graph[i][j] = true;
                }

                if (bombs[j][2] >= distance) {
                    graph[j][i] = true;
                }
            }
        }
        return graph;
    }

    private static double getDistance(final long x1, final long y1, final long x2, final long y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(final String[] args) {
        System.out.println(maximumDetonation(new int[][] {
                {2,1,3},
                {6,1,4}
        }));

        System.out.println(maximumDetonation(new int[][] {
                {1,1,5},
                {10,10,5}
        }));

        System.out.println(maximumDetonation(new int[][] {
                {1,2,3},
                {2,3,1},
                {3,4,2},
                {4,5,3},
                {5,6,4}
        }));

        System.out.println(maximumDetonation(new int[][] {
                {54,95,4},
                {99,46,3},
                {29,21,3},
                {96,72,8},
                {49,43,3},
                {11,20,3},
                {2,57,1},
                {69,51,7}, // 7
                {97,1,10},
                {85,45,2},
                {38,47,1},
                {83,75,3},
                {65,59,3}, // 12
                {33,4,1},
                {32,10,2},
                {20,97,8},
                {35,37,3}
        }));

        System.out.println(maximumDetonation(new int[][] {
                {56,80,2},
                {55,9,10},
                {32,75,2},
                {87,89,1},
                {61,94,3},
                {43,82,9},
                {17,100,6},
                {50,6,7},
                {9,66,7},
                {98,3,6},
                {67,50,2},
                {79,39,5},
                {92,60,10},
                {49,9,9},
                {42,32,10}
        }));
    }
}
