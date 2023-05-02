package in.pervush.leetcode.problems;

public class MaximumProductOfTwoElementsInAnArray {

    final static int MIN = Integer.MIN_VALUE;

    public static int maxProduct(final int[] nums) {
        int max1 = MIN;
        int max2 = MIN;
        for (int num : nums) {
            if(num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max2 - 1) * (max1 - 1);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,4,5,2}));
        System.out.println(maxProduct(new int[]{1,5,4,5}));
        System.out.println(maxProduct(new int[]{3,7}));
    }
}
