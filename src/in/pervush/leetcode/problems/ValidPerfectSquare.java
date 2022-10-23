package in.pervush.leetcode.problems;

import java.util.List;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        for (int i = 1; i * i <= num && i * i > 0; ++i) {
            if (num % i == 0 && i * i == num) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Integer> inputs = List.of(-2,-1,0,1,2,3,4,8,10,11,12,13,14,15,16,2147395600,2147395601, Integer.MAX_VALUE);
        for (int input : inputs) {
            System.out.println(input + " " + isPerfectSquare(input));
        }
    }
}
