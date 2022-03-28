package in.pervush.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    private static int[] SQUARES = new int[10];

    static {
        for (int i = 0; i < SQUARES.length; ++i) {
            SQUARES[i] = i * i;
        }
    }

    private Set<Integer> state = new HashSet<>();

    public boolean isHappy(int n) {
        while (true) {
            if (n == 1) {
                return true;
            }
            if (state.contains(n)) {
                return false;
            }
            state.add(n);
            int nextN = 0;
            while (n != 0) {
                nextN += SQUARES[n % 10];
                n /= 10;
            }
            n = nextN;
        }
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        System.out.println(solution.isHappy(0));
        System.out.println(solution.isHappy(1));
        System.out.println(solution.isHappy(2));
        System.out.println(solution.isHappy(3));
        System.out.println(solution.isHappy(4));
        System.out.println(solution.isHappy(5));
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(Integer.MAX_VALUE));
    }

}
