package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class ValidMountainArray {

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        boolean switched = false;

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] < arr[i]) {
                if (switched) {
                    return false;
                }
            } else if (arr[i - 1] > arr[i]) {
                if (i == 1) {
                    return false;
                }
                if (!switched) {
                    switched = true;
                }
            } else {
                return false;
            }
        }

        return switched;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{2,1}));
        System.out.println(validMountainArray(new int[]{3,5,5}));
        System.out.println(validMountainArray(new int[]{0,3,2,1}));
        System.out.println(validMountainArray(new int[]{0,2,3,4,5,2,1,0}));
        System.out.println(validMountainArray(new int[]{0,2,3,3,5,2,1,0}));
        System.out.println(validMountainArray(new int[]{1,2,3}));
        System.out.println(validMountainArray(new int[]{3,2,1}));
    }

}
