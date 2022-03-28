package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int a = 1;
        for (int i = 0; i < 32; ++i) {
            if ((a & n) == n) {
                return true;
            }
            a <<= 1;
        }
        return false;
    }


    public static void main(String[] args) {
        PowerOfTwo solution = new PowerOfTwo();
        for (int i = -1; i < 1000; ++i) {
            System.out.println(i + " " + solution.isPowerOfTwo(i));
        }
    }
}
