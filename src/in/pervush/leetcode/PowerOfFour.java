package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/power-of-four/
 */
public class PowerOfFour {

    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        int val = 1;
        for (int i = 0; i < 16; i++) {
            val *= 4;
            if (val == n) {
                return true;
            }
            if (val > n) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " " + isPowerOfFour(i));
        }
    }

}
