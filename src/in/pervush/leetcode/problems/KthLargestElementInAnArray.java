package in.pervush.leetcode.problems;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {

    public static int findKthLargest1(final int[] nums, final int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }

    public static int findKthLargest(final int[] nums, final int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    public static int findKthLargest(final int[] nums, final int k, final int startPos, final int endPos) {
        final int pivot = nums[endPos];
        int i = startPos;
        for (int j = startPos; j <= endPos; ++j) {
            if (nums[j] > pivot) {
                swap(nums, i, j);
                ++i;
            }
        }
        swap(nums, i, endPos);

        if (i == k - 1) {
            return nums[i];
        } else if (i < k - 1) {
            return findKthLargest(nums, k, i + 1, endPos);
        } else {
            return findKthLargest(nums, k, startPos, i - 1);
        }
    }

    private static void swap(final int[] nums, final int i, final int j) {
        final int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        final int[] arr = new int[1_000_000_000];
        final var random = new Random();
        for (int i = 0; i< arr.length; ++i) {
            arr[i] = random.nextInt();
        }

        final var start = LocalDateTime.now();
        System.out.println(findKthLargest(arr, 100));
        System.out.println(Duration.between(start, LocalDateTime.now()).getSeconds());

//        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2) + " (5)");
//        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4) + " (4)");
    }
}
