package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */
public class ShortestPathInAGridWithObstaclesElimination {

    private record QueueItem(int i, int j, int k) { }

    private static final int INF = Integer.MAX_VALUE / 2;
    public static int shortestPath(final int[][] grid, final int k) {
        final int[][][] state = new int[k + 1][grid.length][grid[0].length];
        for (final int[][] v1 : state) {
            for (final int[] v2 : v1) {
                Arrays.fill(v2, INF);
            }
            v1[0][0] = 0;
        }
        shortestPath(grid, state, k);
        //print(state);

        int result = INF;
        for (final var v : state) {
            result = Math.min(result, v[v.length - 1][v[0].length - 1]);
        }
        return result >= INF ? -1 : result;
    }

    private static void shortestPath(final int[][] grid, final int[][][] state, final int kk) {
        Queue<QueueItem> queue = new LinkedList<>();
        queue.add(new QueueItem(0, 0, kk));

        while (!queue.isEmpty()) {
            final QueueItem poll = queue.poll();
            final int i = poll.i();
            final int j = poll.j();
            final int k = poll.k();

            if ((i == grid.length - 1 && j == grid[i].length - 1)) {
                return;
            }
            if (j + 1 < grid[i].length) {
                if (grid[i][j + 1] == 0 && state[k][i][j + 1] > state[k][i][j] + 1) {
                    state[k][i][j + 1] = state[k][i][j] + 1;
                    queue.add(new QueueItem(i, j + 1, k));
                } else if (k > 0 && state[k - 1][i][j + 1] > state[k][i][j] + 1) {
                    state[k - 1][i][j + 1] = state[k][i][j] + 1;
                    queue.add(new QueueItem(i, j + 1, k - 1));
                }
            }

            if (i + 1 < grid.length) {
                if (grid[i + 1][j] == 0 && state[k][i + 1][j] > state[k][i][j] + 1) {
                    state[k][i + 1][j] = state[k][i][j] + 1;
                    queue.add(new QueueItem(i + 1, j, k));
                } else if (k > 0 && state[k - 1][i + 1][j] > state[k][i][j] + 1) {
                    state[k - 1][i + 1][j] = state[k][i][j] + 1;
                    queue.add(new QueueItem(i + 1, j, k - 1));
                }
            }

            if (j > 0) {
                if (grid[i][j - 1] == 0 && state[k][i][j - 1] > state[k][i][j] + 1) {
                    state[k][i][j - 1] = state[k][i][j] + 1;
                    queue.add(new QueueItem(i, j - 1, k));
                } else if (k > 0 && state[k - 1][i][j - 1] > state[k][i][j] + 1) {
                    state[k - 1][i][j - 1] = state[k][i][j] + 1;
                    queue.add(new QueueItem(i, j - 1, k - 1));
                }
            }

            if (i > 0) {
                if (grid[i - 1][j] == 0 && state[k][i - 1][j] > state[k][i][j] + 1) {
                    state[k][i - 1][j] = state[k][i][j] + 1;
                    queue.add(new QueueItem(i - 1, j, k));
                } else if (k > 0 && state[k - 1][i - 1][j] > state[k][i][j] + 1) {
                    state[k - 1][i - 1][j] = state[k][i][j] + 1;
                    queue.add(new QueueItem(i - 1, j, k - 1));
                }
            }
        }
    }

    // DFS
//    private static void shortestPath1(final int[][] grid, final int[][][] state, final int k, final int i, final int j) {
//        if ((i == grid.length - 1 && j == grid[i].length - 1)) {
//            return;
//        }
//        if (j + 1 < grid[i].length) {
//            if (grid[i][j + 1] == 0 && state[k][i][j + 1] > state[k][i][j] + 1) {
//                state[k][i][j + 1] = state[k][i][j] + 1;
//                shortestPath(grid, state, k, i, j + 1);
//            } else if (k > 0 && state[k - 1][i][j + 1] > state[k][i][j] + 1) {
//                state[k - 1][i][j + 1] = state[k][i][j] + 1;
//                shortestPath(grid, state, k - 1, i, j + 1);
//            }
//        }
//
//        if (i + 1 < grid.length) {
//            if (grid[i + 1][j] == 0 && state[k][i + 1][j] > state[k][i][j] + 1) {
//                state[k][i + 1][j] = state[k][i][j] + 1;
//                shortestPath(grid, state, k, i + 1, j);
//            } else if (k > 0 && state[k - 1][i + 1][j] > state[k][i][j] + 1) {
//                state[k - 1][i + 1][j] = state[k][i][j] + 1;
//                shortestPath(grid, state, k - 1, i + 1, j);
//            }
//        }
//
//        if (j > 0) {
//            if (grid[i][j - 1] == 0 && state[k][i][j - 1] > state[k][i][j] + 1) {
//                state[k][i][j - 1] = state[k][i][j] + 1;
//                shortestPath(grid, state, k, i, j - 1);
//            } else if (k > 0 && state[k - 1][i][j - 1] > state[k][i][j] + 1) {
//                state[k - 1][i][j - 1] = state[k][i][j] + 1;
//                shortestPath(grid, state, k - 1, i, j - 1);
//            }
//        }
//
//        if (i > 0) {
//            if (grid[i - 1][j] == 0 && state[k][i - 1][j] > state[k][i][j] + 1) {
//                state[k][i - 1][j] = state[k][i][j] + 1;
//                shortestPath(grid, state, k, i - 1, j);
//            } else if (k > 0 && state[k - 1][i - 1][j] > state[k][i][j] + 1) {
//                state[k - 1][i - 1][j] = state[k][i][j] + 1;
//                shortestPath(grid, state, k - 1, i - 1, j);
//            }
//        }
//    }

    private static void print(final int[][][] state) {
        for (int[][] v1 : state) {
            for (int[] v2 : v1) {
                System.out.println(Arrays.toString(v2));
            }
            System.out.println();
        }
    }

    private static void test1() {
        System.out.println(shortestPath(new int[][] {
                new int[] {0,0,0},
                new int[] {1,1,0},
                new int[] {0,0,0},
                new int[] {0,1,1},
                new int[] {0,0,0}
        }, 1));
    }

    private static void test2() {
        System.out.println(shortestPath(new int[][] {
                new int[] {0,1,1},
                new int[] {1,1,1},
                new int[] {1,0,0}
        }, 1));
    }

    private static void test3() {
        System.out.println(shortestPath(new int[][] {
                new int[] {0,1,0,0,0},
                new int[] {0,1,0,1,0},
                new int[] {0,1,0,1,0},
                new int[] {0,1,0,1,0},
                new int[] {0,0,0,1,0}
        }, 0) + " (16)");
    }

    private static void test4() {
        System.out.println(shortestPath(new int[][] {
                new int[] {0,1,0,0,0},
                new int[] {0,1,0,1,0},
                new int[] {0,1,0,1,0},
                new int[] {0,1,0,1,0},
                new int[] {0,0,0,1,0}
        }, 1) + " (8)");
    }

    private static void test5() {
        System.out.println(shortestPath(new int[][] {
                new int[] {0,0,0,1,0,1,0,0,0,1,0,1,1,1,1,0,0,0},
                new int[] {1,0,0,0,1,0,0,1,0,0,1,0,0,1,0,1,1,0},
                new int[] {1,0,0,1,1,1,0,0,0,1,1,0,0,1,1,1,0,1},
                new int[] {0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,1,0,1},
                new int[] {1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1},
                new int[] {0,0,1,1,0,0,0,1,0,0,0,1,0,0,1,1,0,0},
                new int[] {0,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,0,0},
                new int[] {1,1,1,0,1,0,1,0,1,0,0,0,0,0,0,1,0,0},
                new int[] {0,0,1,1,0,0,1,0,0,1,1,1,1,1,0,0,1,0},
                new int[] {1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0},
                new int[] {0,0,1,1,1,0,0,0,1,1,0,1,0,1,1,1,1,0},
                new int[] {1,0,0,0,0,0,1,0,0,1,1,0,1,0,0,1,1,1},
                new int[] {0,0,1,0,1,0,0,0,1,1,0,0,1,0,1,0,0,0},
                new int[] {1,1,0,0,1,1,1,0,0,0,1,0,0,0,1,0,1,0},
                new int[] {1,0,1,1,1,1,0,1,0,1,0,1,0,0,0,0,0,0},
                new int[] {0,0,0,0,0,1,0,1,0,0,0,1,1,1,1,1,1,0},
                new int[] {0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,1},
                new int[] {0,1,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,0},
                new int[] {1,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,1,1},
                new int[] {0,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,1,0},
                new int[] {0,1,1,0,1,0,0,1,0,1,0,0,0,0,0,0,1,1},
                new int[] {1,1,0,0,1,0,0,1,0,1,1,1,0,0,0,1,0,1},
                new int[] {0,0,1,1,0,1,0,1,0,1,1,1,0,0,1,1,0,1},
                new int[] {0,1,0,0,0,0,1,0,1,0,1,0,1,1,1,0,1,0},
                new int[] {0,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,1,1},
                new int[] {0,1,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,0},
                new int[] {0,0,1,0,1,0,1,1,1,0,1,0,0,0,0,0,1,1},
                new int[] {0,0,0,1,1,0,0,1,1,0,0,0,0,1,0,0,1,0},
                new int[] {1,1,1,1,0,1,0,0,1,0,0,0,1,1,0,0,1,0},
                new int[] {0,1,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0},
                new int[] {1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0},
                new int[] {1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,0,0,1},
                new int[] {0,0,0,0,1,0,1,1,1,1,1,0,0,1,0,1,0,1},
                new int[] {1,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,1,0},
                new int[] {1,0,1,1,1,0,1,0,0,1,1,0,0,1,1,1,0,0},
                new int[] {1,1,1,1,1,1,0,0,0,0,0,1,0,0,1,1,1,0},
                new int[] {0,1,0,0,1,1,1,0,0,0,1,1,0,1,0,0,1,0},
                new int[] {1,0,1,1,0,0,0,0,0,1,1,1,0,0,1,1,1,1},
                new int[] {1,1,0,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0},
                new int[] {0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,0}
        }, 696) + " (56)");
    }

    public static void main(final String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
