package in.pervush.leetcode.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class SumOfSquareNumbers {

    public static boolean judgeSquareSum(final int c) {
        for (int a = 0; a * a <= c && a * a >= 0; ++a) {
            final double b = Math.sqrt(c - a * a);
            if (b == (int)b) {
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSumSlow(final int c) {
        final Set<Integer> squares = new HashSet<>();
        for (int i = 0; i <= c; ++i) {
            int square = i * i;
            if (square < 0) {
                break;
            }
            squares.add(square);
        }

        for (int square : squares) {
            if (squares.contains(c - square)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Integer> inputs = List.of(-2,-1,0,1,2,3,4,5,8,10,11,12,13,14,15,16,2147395600,2147395601, Integer.MAX_VALUE);
        for (int input : inputs) {
            System.out.println(input + " " + judgeSquareSum(input));
        }
    }
}
