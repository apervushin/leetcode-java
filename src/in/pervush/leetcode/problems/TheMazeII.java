package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-maze-ii/
 */
public class TheMazeII {

    private static final int INF = 100 * 100 + 1;

    public static int shortestDistance(final int[][] maze, final int[] start, final int[] destination) {
        final int[][] distance = new int[maze.length][maze[0].length];
        for (final var arr : distance) {
            Arrays.fill(arr , INF);
        }
        final boolean[][] visited = new boolean[maze.length][maze[0].length];
        final PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> distance[a[0]][a[1]]));
        distance[start[0]][start[1]] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            final int[] pos = queue.poll();
            final int x = pos[0];
            final int y = pos[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            if (x > 0 && maze[x - 1][y] == 0) {
                int xNext = x;
                while (xNext > 0 && maze[xNext - 1][y] == 0) {
                    --xNext;
                }
                distance[xNext][y] = Math.min(distance[xNext][y], distance[x][y] + x - xNext);
                if (!visited[xNext][y]) {
                    queue.add(new int[]{xNext, y});
                }
            }

            if (x < maze.length - 1 && maze[x + 1][y] == 0) {
                int xNext = x;
                while (xNext < maze.length - 1 && maze[xNext + 1][y] == 0) {
                    ++xNext;
                }
                distance[xNext][y] = Math.min(distance[xNext][y], distance[x][y] + xNext - x);
                if (!visited[xNext][y]) {
                    queue.add(new int[]{xNext, y});
                }
            }

            if (y > 0 && maze[x][y - 1] == 0) {
                int yNext = y;
                while (yNext > 0 && maze[x][yNext - 1] == 0) {
                    --yNext;
                }
                distance[x][yNext] = Math.min(distance[x][yNext], distance[x][y] + y - yNext);
                if (!visited[x][yNext]) {
                    queue.add(new int[]{x, yNext});
                }
            }

            if (y < maze[x].length - 1 && maze[x][y + 1] == 0) {
                int yNext = y;
                while (yNext < maze[x].length - 1 && maze[x][yNext + 1] == 0) {
                    ++yNext;
                }
                distance[x][yNext] = Math.min(distance[x][yNext], distance[x][y] + yNext - y);
                if (!visited[x][yNext]) {
                    queue.add(new int[]{x, yNext});
                }
            }
        }

        final int result = distance[destination[0]][destination[1]];
        return result == INF ? -1 : result;
    }

    private static void test1() {
        System.out.println(shortestDistance(new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        }, new int[] {0,4}, new int[] {4,4}) + " (12)");
    }

    private static void test2() {
        System.out.println(shortestDistance(new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        }, new int[] {0,4}, new int[] {3,2}) + " (-1)");
    }

    public static void main(final String[] args) {
        test1();
        test2();
    }
}
