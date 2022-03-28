package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/minimum-path-sum/submissions/
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        for (int i = 1; i < grid.length; ++i) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; ++i) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[i].length; ++j) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    private static void print(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int val : rows) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    private static void test1() {
        int[][] input = new int[][] {
                new int[] {1,3,1},
                new int[] {1,5,1},
                new int[] {4,2,1}
        };
        System.out.println(minPathSum(input));
    }

    private static void test2() {
        int[][] input = new int[][] {
                new int[] {1,2,3},
                new int[] {4,5,6}
        };
        System.out.println(minPathSum(input));
    }

    private static void test3() {
        int[][] input = new int[][] {
                new int[] {1}
        };
        System.out.println(minPathSum(input));
    }

    private static void test4() {
        int[][] input = new int[][] {
                new int[] {}
        };
        System.out.println(minPathSum(input));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
