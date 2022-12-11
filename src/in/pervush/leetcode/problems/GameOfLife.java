package in.pervush.leetcode.problems;

import in.pervush.leetcode.utils.PrintUtils;

/**
 * https://leetcode.com/problems/game-of-life/
 */
public class GameOfLife {

    public static void gameOfLife(final int[][] board) {
        final int[][] result = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                final int val = board[i][j];
                int cnt1 = countLiveNeighbours(board, i, j);

                if (val == 1 && cnt1 < 2) {
                    result[i][j] = 0;
                } else if (val == 1 && cnt1 <= 3) {
                    result[i][j] = 1;
                } else if (val == 1 && cnt1 > 3) {
                    result[i][j] = 0;
                } else if (val == 0 && cnt1 == 3) {
                    result[i][j] = 1;
                }
            }
        }

        System.arraycopy(result, 0, board, 0, board.length);
    }

    private static int countLiveNeighbours(final int[][] board, final int i, final int j) {
        int cnt = 0;

        if (i > 0 && j > 0) {
            cnt += board[i - 1][j - 1];
        }
        if (i > 0) {
            cnt += board[i - 1][j];
        }
        if (j > 0) {
            cnt += board[i][j - 1];
        }

        if (i < board.length - 1 && j < board[0].length - 1) {
            cnt += board[i + 1][j + 1];
        }
        if (i < board.length - 1) {
            cnt += board[i + 1][j];
        }
        if (j < board[0].length - 1) {
            cnt += board[i][j + 1];
        }

        if (i > 0 && j < board[0].length - 1) {
            cnt += board[i - 1][j + 1];
        }

        if (i < board.length - 1 && j > 0) {
            cnt += board[i + 1][j - 1];
        }

        return cnt;
    }

    public static void main(final String[] args) {
        var input = new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(input);
        PrintUtils.print(input);

        input = new int[][] {{1,1},{1,0}};
        gameOfLife(input);
        PrintUtils.print(input);
    }
}
