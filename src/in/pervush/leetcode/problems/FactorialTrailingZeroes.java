package in.pervush.leetcode.problems;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int result = 0;
        while (n / 5 != 0) {
            n /= 5;
            result += n;
        }
        return result;
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        while (n != 0) {
            result = result.multiply(BigInteger.valueOf(n));
            --n;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes solution = new FactorialTrailingZeroes();
        for (int i = 1; i <= 30; ++i) {
            System.out.println(i + " " + solution.trailingZeroes(i) + " " + factorial(i));
        }
    }

}
