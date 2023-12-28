package in.pervush.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/power-of-four/
 */
public class PowerOfFour {

    private static final Set<Integer> POWER = new HashSet<>();

    static {
        POWER.add(1);

        int val = 1;
        for (int i = 0; i < 15; i++) {
            val *= 4;
            POWER.add(val);
        }
    }

    public static boolean isPowerOfFour(int n) {
        return POWER.contains(n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " " + isPowerOfFour(i));
        }
    }

}
