package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 *
 * Theory:
 * https://dou.ua/lenta/articles/union-find/
 */
public class TheEarliestMomentWhenEveryoneBecomeFriends {

    private static class DSU {

        private final int[] nodes;

        public DSU(final int n) {
            nodes = new int[n];
            for (int i = 0; i < n; ++i) {
                nodes[i] = i;
            }
        }

        public void union(final int p, final int q) {
            int pRoot = getRoot(p);
            int qRoot = getRoot(q);
            nodes[qRoot] = pRoot;
        }

        public boolean isConnected(final int p, final int q) {
            return getRoot(p) == getRoot(q);
        }

        public boolean isAllConnected() {
            for (int i = 1; i < nodes.length; ++i) {
                if (getRoot(i - 1) != getRoot(i)) {
                    return false;
                }
            }
            return true;
        }

        private int getRoot(int nodeIndex) {
            while (nodeIndex != nodes[nodeIndex]) {
                nodeIndex = nodes[nodeIndex];
            }
            return nodeIndex;
        }
    }

    public static int earliestAcq(final int[][] logs, final int n) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        final DSU dsu = new DSU(n);

        for (final var log : logs) {
            dsu.union(log[1], log[2]);
            dsu.union(log[2], log[1]);
            if (dsu.isAllConnected()) {
                return log[0];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(earliestAcq(new int[][] {
                new int[] {20190101,0,1},
                new int[] {20190104,3,4},
                new int[] {20190107,2,3},
                new int[] {20190211,1,5},
                new int[] {20190224,2,4},
                new int[] {20190301,0,3},
                new int[] {20190312,1,2},
                new int[] {20190322,4,5},
        }, 6));
    }
}
