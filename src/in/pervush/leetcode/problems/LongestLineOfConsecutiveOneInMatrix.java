package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 */
public class LongestLineOfConsecutiveOneInMatrix {

    public static int longestLine(final int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        int result = 0;

        for (int i = 0; i < n; ++i) {
            int current = 0;
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1) {
                    ++current;
                } else {
                    result = Math.max(result, current);
                    current = 0;
                }
            }
            result = Math.max(result, current);
        }

        for (int i = 0; i < m; ++i) {
            int current = 0;
            for (int j = 0; j < n; ++j) {
                if (mat[j][i] == 1) {
                    ++current;
                } else {
                    result = Math.max(result, current);
                    current = 0;
                }
            }
            result = Math.max(result, current);
        }

        for (int k = 0; k < n + m; ++k) {
            int i = k < n ? n - k - 1 : 0;
            int j = k < n ? 0 : k - n + 1;
            //System.out.println(k + ": " + i + " " + j);
            int current = 0;
            while (i < n && j < m) {
                if (mat[i][j] == 1) {
                    ++current;
                } else {
                    result = Math.max(result, current);
                    current = 0;
                }
                ++i;
                ++j;
            }
            result = Math.max(result, current);
        }

        for (int k = 0; k < m + n; ++k) {
            int i = k < m ? 0 : k - m;
            int j = k < m ? k : m - 1;
            //System.out.println(k + ": " + i + " " + j);
            int current = 0;
            while (i < n && j >= 0) {
                if (mat[i][j] == 1) {
                    ++current;
                } else {
                    result = Math.max(result, current);
                    current = 0;
                }
                ++i;
                --j;
            }
            result = Math.max(result, current);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestLine(new int[][] {
                new int[] {1,0,0,0},
                new int[] {1,0,0,0},
                new int[] {1,0,0,0},
                new int[] {1,0,0,0},
        }));
        System.out.println(longestLine(new int[][] {
                new int[] {0,0,0,0},
                new int[] {1,1,1,1},
                new int[] {0,0,0,0},
                new int[] {0,0,0,0},
        }));
        System.out.println(longestLine(new int[][] {
                new int[] {1,0,0,0},
                new int[] {0,1,0,0},
                new int[] {0,0,1,0},
                new int[] {0,0,0,1},
        }));
        System.out.println(longestLine(new int[][] {
                new int[] {0,0,0,1},
                new int[] {0,0,1,0},
                new int[] {0,1,0,0},
                new int[] {1,0,0,0},
        }));

        System.out.println(longestLine(new int[][] {
                new int[] {1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1},
        }));

        System.out.println(longestLine(new int[][] {
                new int[] {0},
                new int[] {0},
                new int[] {1},
                new int[] {0},
                new int[] {0}
        }));
    }
}
