package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i < result.length; ++i) {
            int val = i;
            for (int j = 0; j < Integer.SIZE; ++j) {
                result[i] += val & 1;
                val >>= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = countBits(100);
        for (int i = 0; i < result.length; ++i) {
            System.out.println(Integer.toBinaryString(i) + " " + result[i]);
        }
    }
}
