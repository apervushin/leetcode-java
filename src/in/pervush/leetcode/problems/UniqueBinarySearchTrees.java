package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    private static final int MAX_N = 19;
    private static final int[] CACHE = new int[MAX_N + 1];
    private static int MIN_PRECALCULATED_N = 1;

    static {
        Arrays.fill(CACHE, -1);
        CACHE[0] = 1;
        CACHE[1] = 1;
    }

    public static int numTrees(final int n) {
        for (int i = MIN_PRECALCULATED_N + 1; i <= n; ++i) {
            int result = 0;
            for (int j = 1; j <= i; ++j) { // root number
                result += CACHE[j - 1] * CACHE[i - j];
            }
            CACHE[i] = result;
            MIN_PRECALCULATED_N = i;
        }
        return CACHE[n];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 19; ++i) {
            System.out.println(i + " " + numTrees(i));
        }
    }
}
