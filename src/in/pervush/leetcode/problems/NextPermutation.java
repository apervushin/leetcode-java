package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    private record TestCase(int[] input, int[] expectedOutput){}

    private static void swap(final int[] nums, final int i, final int j) {
        final int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(final int[] nums, final int startPos, final int endPos) {
        int i = startPos;
        int j = endPos;
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }

    public static void nextPermutation(final int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int i;
        for (i = nums.length - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                int minRightPos = -1;
                for (int j = nums.length - 1; j >= i; --j) {
                    if (nums[j] > nums[i - 1]) {
                        minRightPos = j;
                        break;
                    }
                }

                swap(nums, i - 1, minRightPos);

                reverse(nums, i, nums.length - 1);
                break;
            }
        }
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
        }
    }

    public static void main(final String[] args) {
        final var testCases = List.of(
                new TestCase(new int[] {1,2,3}, new int[] {1,3,2}),
                new TestCase(new int[] {1,3,2}, new int[] {2,1,3}),
                new TestCase(new int[] {2,1,3}, new int[] {2,3,1}),
                new TestCase(new int[] {2,3,1}, new int[] {3,1,2}),
                new TestCase(new int[] {3,1,2}, new int[] {3,2,1}),
                new TestCase(new int[] {3,2,1}, new int[] {1,2,3}),

                new TestCase(new int[] {1,2,3,4}, new int[] {1,2,4,3}),
                new TestCase(new int[] {1,2,4,3}, new int[] {1,3,2,4}),
                new TestCase(new int[] {1,3,2,4}, new int[] {1,3,4,2}),
                new TestCase(new int[] {1,3,4,2}, new int[] {1,4,2,3}),
                new TestCase(new int[] {1,4,2,3}, new int[] {1,4,3,2}),
                new TestCase(new int[] {1,4,3,2}, new int[] {2,1,3,4}),
                new TestCase(new int[] {2,1,3,4}, new int[] {2,1,4,3}),
                new TestCase(new int[] {2,1,4,3}, new int[] {2,3,1,4}),
                new TestCase(new int[] {2,3,1,4}, new int[] {2,3,4,1}),
                new TestCase(new int[] {2,3,4,1}, new int[] {2,4,1,3}),
                new TestCase(new int[] {2,4,1,3}, new int[] {2,4,3,1}),
                // ...
                new TestCase(new int[] {4,1,2,3}, new int[] {4,1,3,2}),
                new TestCase(new int[] {4,1,3,2}, new int[] {4,2,1,3}),
                new TestCase(new int[] {4,2,1,3}, new int[] {4,2,3,1}),
                new TestCase(new int[] {4,2,3,1}, new int[] {4,3,1,2}),
                new TestCase(new int[] {4,3,1,2}, new int[] {4,3,2,1})
        );
        testCases.forEach(testCase -> {
            final var copy = Arrays.copyOf(testCase.input, testCase.input.length);
            nextPermutation(testCase.input);
            System.out.println(Arrays.toString(copy) + " -> " + Arrays.toString(testCase.input) + " ("
                    + Arrays.equals(testCase.input, testCase.expectedOutput) + ", "
                    + Arrays.toString(testCase.expectedOutput) + ")");
        });
    }
}
