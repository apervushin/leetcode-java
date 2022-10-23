package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (nums[i] > nums[j]) {
            int newPos = i + ((j - i) / 2);
            if (nums[i] <= nums[newPos]) {
                i = newPos + 1;
            } else {
                j = newPos;
            }
        }

        return nums[i];
    }

    private static void test1() {
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
    }

    private static void test2() {
        System.out.println(findMin(new int[] {0,1,2,4,5,6,7}));
    }

    private static void test3() {
        System.out.println(findMin(new int[] {3,4,5,1,2}));
    }

    private static void test4() {
        System.out.println(findMin(new int[] {11,13,15,17}));
    }

    private static void test5() {
        System.out.println(findMin(new int[] {2,1}));
    }

    private static void test6() {
        System.out.println(findMin(new int[] {1}));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
