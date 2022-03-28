package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        while (n != 1) {
            if (n % 5 == 0) {
                n /= 5;
                continue;
            }
            if (n % 3 == 0) {
                n /= 3;
                continue;
            }
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        UglyNumber solution = new UglyNumber();

        System.out.println(0 + " " + solution.isUgly(0));
        System.out.println(1 + " " + solution.isUgly(1));
        System.out.println(2 + " " + solution.isUgly(2));
        System.out.println(3 + " " + solution.isUgly(3));
        System.out.println(4 + " " + solution.isUgly(4));
        System.out.println(5 + " " + solution.isUgly(5));
        System.out.println(6 + " " + solution.isUgly(6));
        System.out.println(14 + " " + solution.isUgly(14));
        System.out.println(Integer.MAX_VALUE + " " + solution.isUgly(Integer.MAX_VALUE));
    }
}
