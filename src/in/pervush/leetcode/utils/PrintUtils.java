package in.pervush.leetcode.utils;

import java.util.Arrays;

public class PrintUtils {

    private PrintUtils() {}

    public static void print(final int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(final String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(final int[][] arr) {
        for (final int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void print(final int[][][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                for (int k = 0; k < arr[i][j].length; ++k) {
                    System.out.println("(" + i + "," + j + "," + k + ") -> " + arr[i][j][k]);
                }
            }
        }
    }
}
