package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/the-maze/
 */
public class TheMaze {

    public static boolean hasPath(final int[][] maze, final int[] start, final int[] destination) {
        final boolean[][] visited = new boolean[maze.length][maze[0].length];
        return hasPath(maze, start[0], start[1], destination[0], destination[1], visited);
    }
    
    public static boolean hasPath(final int[][] maze, final int x, final int y, final int xDest, final int yDest,
                                  final boolean[][] visited) {
        if (x == xDest && y == yDest) {
            return true;
        }
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;

        // left
        if (x > 0 && maze[x - 1][y] == 0) {
            int xNext = x;
            while (xNext > 0 && maze[xNext - 1][y] == 0) {
                --xNext;
            }
            if (hasPath(maze, xNext, y, xDest, yDest, visited)) {
                return true;
            }
        }
        // right
        if (x < maze.length - 1 && maze[x + 1][y] == 0) {
            int xNext = x;
            while (xNext < maze.length - 1 && maze[xNext + 1][y] == 0) {
                ++xNext;
            }
            if (hasPath(maze, xNext, y, xDest, yDest, visited)) {
                return true;
            }
        }
        // up
        if (y > 0 && maze[x][y - 1] == 0) {
            int yNext = y;
            while (yNext > 0 && maze[x][yNext - 1] == 0) {
                --yNext;
            }
            if (hasPath(maze, x, yNext, xDest, yDest, visited)) {
                return true;
            }
        }
        // down
        if (y < maze[x].length - 1 && maze[x][y + 1] == 0) {
            int yNext = y;
            while (yNext < maze[x].length - 1 && maze[x][yNext + 1] == 0) {
                ++yNext;
            }
            if (hasPath(maze, x, yNext, xDest, yDest, visited)) {
                return true;
            }
        }

        return false;
    }

    private static void test1() {
        System.out.println(hasPath(new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        }, new int[] {0,4}, new int[] {4,4}) + " (true)");
    }

    private static void test2() {
        System.out.println(hasPath(new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        }, new int[] {0,4}, new int[] {3,2}) + " (false)");
    }

    public static void main(final String[] args) {
        test1();
        test2();
    }
}
