package in.pervush.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-and-sum-of-array/
 */
public class MaximumANDSumOfArray {

    public static int maximumANDSum(final int[] nums, final int numSlots) {
        int slots = 2;
        for (int i = 1; i < numSlots; ++i) {
            slots = slots * 10 + 2;
        }
        return maximumANDSum(nums, numSlots, slots, 0, new HashMap<>());
    }

    public static int maximumANDSum(final int[] nums, final int numSlots, final int slots, final int pos,
                                    final Map<Integer, Integer> state) {
        if (pos == nums.length) {
            return 0;
        }
        final var stateResult = state.get(slots);
        if (stateResult != null) {
            return stateResult;
        }

        int result = 0;
        int base = 1;
        for (int s = 1; s <= numSlots; ++s) {
            if (slots / base % 10 != 0) {
                result = Math.max(
                        result,
                        maximumANDSum(nums, numSlots, slots - base, pos + 1, state) + (s & nums[pos])
                );
            }
            base *= 10;
        }
        state.put(slots, result);
        return result;
    }

    public static void main(final String[] args) {
        System.out.println(maximumANDSum(new int[] {1,2,3,4,5,6}, 3) + " (9)");
        System.out.println(maximumANDSum(new int[] {1,3,10,4,7,1}, 9) + " (24)");
        System.out.println(maximumANDSum(new int[] {14,7,9,8,2,4,11,1,9}, 8) + " (40)");
        System.out.println(maximumANDSum(new int[] {8,13,3,15,3,15,2,15,5,7,6}, 8) + " (60)");
    }
}
