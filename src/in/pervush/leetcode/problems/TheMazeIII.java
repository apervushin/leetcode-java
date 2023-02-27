package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-maze-iii/
 */
public class TheMazeIII {

    private record Point(int x, int y, String path) {}
    private static final int INF = 100 * 100 + 1;
    public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        final int[][] distance = new int[maze.length][maze[0].length];
        for (final var arr : distance) {
            Arrays.fill(arr , INF);
        }
        final boolean[][] visited = new boolean[maze.length][maze[0].length];
        final Point[][] path = new Point[maze.length][maze[0].length];
        final PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            final int compare = Integer.compare(distance[a[0]][a[1]], distance[b[0]][b[1]]);
            if (compare == 0) {
                return Integer.compare(a[2], b[2]);
            }
            return compare;
        });
        distance[ball[0]][ball[1]] = 0;
        path[ball[0]][ball[1]] = new Point(ball[0], ball[1], "");
        queue.add(ball);
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
                while (xNext > 0 && maze[xNext - 1][y] == 0 && !(xNext == hole[0] && y == hole[1])) {
                    --xNext;
                }
                final int nextDistance = distance[x][y] + x - xNext;
                if (distance[xNext][y] > nextDistance || (distance[xNext][y] == nextDistance && path[xNext][y].path().compareTo(path[x][y].path() + "u") > 0)) {
                    distance[xNext][y] = nextDistance;
                    path[xNext][y] = new Point(x, y, path[x][y].path() + "u");
                }
                if (!visited[xNext][y]) {
                    queue.add(new int[]{xNext, y, 3});
                }
            }

            if (x < maze.length - 1 && maze[x + 1][y] == 0) {
                int xNext = x;
                while (xNext < maze.length - 1 && maze[xNext + 1][y] == 0 && !(xNext == hole[0] && y == hole[1])) {
                    ++xNext;
                }
                final int nextDistance = distance[x][y] + xNext - x;
                if (distance[xNext][y] > nextDistance || (distance[xNext][y] == nextDistance && path[xNext][y].path().compareTo(path[x][y].path() + "d") > 0)) {
                    distance[xNext][y] = nextDistance;
                    path[xNext][y] = new Point(x, y, path[x][y].path() + "d");
                }
                if (!visited[xNext][y]) {
                    queue.add(new int[]{xNext, y, 0});
                }
            }

            if (y > 0 && maze[x][y - 1] == 0) {
                int yNext = y;
                while (yNext > 0 && maze[x][yNext - 1] == 0 && !(x == hole[0] && yNext == hole[1])) {
                    --yNext;
                }
                final int nextDistance = distance[x][y] + y - yNext;
                if (distance[x][yNext] > nextDistance || (distance[x][yNext] == nextDistance && path[x][yNext].path().compareTo(path[x][y].path() + "l") > 0)) {
                    distance[x][yNext] = nextDistance;
                    path[x][yNext] = new Point(x, y, path[x][y].path() + "l");
                }
                if (!visited[x][yNext]) {
                    queue.add(new int[]{x, yNext, 1});
                }
            }

            if (y < maze[x].length - 1 && maze[x][y + 1] == 0) {
                int yNext = y;
                while (yNext < maze[x].length - 1 && maze[x][yNext + 1] == 0 && !(x == hole[0] && yNext == hole[1])) {
                    ++yNext;
                }
                final int nextDistance = distance[x][y] + yNext - y;
                if (distance[x][yNext] > nextDistance || (distance[x][yNext] == nextDistance && path[x][yNext].path().compareTo(path[x][y].path() + "r") > 0)) {
                    distance[x][yNext] = nextDistance;
                    path[x][yNext] = new Point(x, y, path[x][y].path() + "r");
                }
                if (!visited[x][yNext]) {
                    queue.add(new int[]{x, yNext, 2});
                }
            }
        }

        if (distance[hole[0]][hole[1]] == INF) {
            return "impossible";
        }

        return path[hole[0]][hole[1]].path();
    }

    private static void test1() {
        System.out.println(findShortestWay(new int[][] {
                {0,0,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {0,1,0,0,1},
                {0,1,0,0,0}
        }, new int[] {4,3}, new int[] {0,1}) + " (lul)");
    }

    private static void test2() {
        System.out.println(findShortestWay(new int[][] {
                {0,0,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {0,1,0,0,1},
                {0,1,0,0,0}
        }, new int[] {4,3}, new int[] {3,0}) + " (impossible)");
    }

    private static void test3() {
        System.out.println(findShortestWay(
                new int[][] {{0,0,0,0,0,0,0},{0,0,1,0,0,1,0},{0,0,0,0,1,0,0},{0,0,0,0,0,0,1}},
                new int[] {0,4},
                new int[] {3,5}
        ) + " (dldr)");
    }

    public static void main(final String[] args) {
        test1();
        test2();
        test3();
    }
}
