package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public static int search(final int[] nums, final int target) {
        final int rotatePos = getRotatePos(nums, 0, nums.length - 1);
        if (rotatePos == -1) {
            return findTargetPos(nums, 0, nums.length - 1, target);
        } else if (nums[nums.length - 1] >= target) {
            return findTargetPos(nums, rotatePos + 1, nums.length - 1, target);
        } else if (nums[rotatePos] >= target) {
            return findTargetPos(nums, 0, rotatePos, target);
        }
        return -1;
    }

    private static int findTargetPos(final int[] nums, final int startPos, final int endPos, final int target) {
        final int pos = Arrays.binarySearch(nums, startPos, endPos + 1, target);
        return pos < 0 ? -1 : pos;
    }

    private static int getRotatePos(final int[] nums, final int startPos, final int endPos) {
        if (startPos == endPos - 1 && nums[startPos] > nums[endPos]) {
            return startPos;
        }
        final int midPos = startPos + ((endPos - startPos) / 2);

        if (nums[startPos] > nums[midPos]) {
            return getRotatePos(nums, startPos, midPos);
        } else if (nums[midPos] > nums[endPos]) {
            return getRotatePos(nums, midPos, endPos);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0) + " (4)\n");
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3) + " (-1)\n");
        System.out.println(search(new int[] {1}, 0) + " (-1)\n");
        System.out.println(search(new int[] {1,2}, 1) + " (0)\n");
        System.out.println(search(new int[] {1,2}, 2) + " (1)\n");
        System.out.println(search(new int[] {2,1}, 1) + " (1)\n");
        System.out.println(search(new int[] {2,1}, 2) + " (0)\n");
    }
}
