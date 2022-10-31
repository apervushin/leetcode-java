package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-number-of-books-you-can-take/
 */
public class MaximumNumberOfBooksYouCanTake {

    public static long maximumBooks1(final int[] books) {
        final long[] dp = new long[books.length];

        for (int i = 0; i < books.length; ++i) {
            int prev = books[i];
            long sum = books[i];
            for (int j = i - 1; j >= 0 && prev > 0; --j) {
                prev = Math.min(books[j], Math.max(prev - 1, 0));
                sum += prev;
            }
            dp[i] = sum;
        }

        return Arrays.stream(dp).max().getAsLong();
    }

    public static long maximumBooks(final int[] books) {
        final long[] dp = new long[books.length];
        final Stack<Integer> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i <  books.length; ++i) {
            while (!stack.isEmpty() && books[stack.peek()] >= books[i] - i + stack.peek()) {
                stack.pop();
            }

            dp[i] = (stack.isEmpty() ? 0 : dp[stack.peek()]) +
                    getSum(books[i]) -
                    getSum(books[i] - i + (stack.isEmpty() ? -1 : stack.peek()));

            stack.push(i);
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    // sum element from 1 to n
    private static long getSum(final int n) {
        if (n < 0) {
            return 0;
        }
        return ((long) n) * (long) (n + 1) / 2;
    }

    public static void main(final String[] args) {
        System.out.println(maximumBooks(new int[] {8,5,2,7,9}) + " (19)");
        System.out.println(maximumBooks(new int[] {7,0,3,4,5}) + " (12)");
        System.out.println(maximumBooks(new int[] {8,2,3,7,3,4,0,1,4,3}) + " (13)");
    }

}
