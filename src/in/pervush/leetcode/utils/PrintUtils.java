package in.pervush.leetcode.utils;

import java.util.Arrays;
import java.util.BitSet;

public class PrintUtils {

    private PrintUtils() {}

    public static void print(final int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(final char[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(final double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(final long[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(final String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(final Integer[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static <T> void print(final T[][] arr) {
        for (final var row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void print(final int[][] arr) {
        for (final var row : arr) {
            print(row);
        }
    }

    public static void print(final char[][] arr) {
        for (final var row : arr) {
            print(row);
        }
    }

    public static void print(final long[][] arr) {
        for (final var row : arr) {
            print(row);
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

    public static void print(final BitSet bitSet) {
        print(bitSet, bitSet.size());
    }
    public static void print(final BitSet bitSet, final int limit) {
        for (int i = 0; i < limit; ++i) {
            System.out.print(bitSet.get(i) ? '1' : '0');
        }
        System.out.println();
    }
}
