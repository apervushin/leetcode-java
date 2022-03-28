package in.pervush.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final int n = nums.length;
        final Map<Integer, Integer> lastPositions = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            Integer prevPos = lastPositions.get(nums[i]);
            if (prevPos != null && i - prevPos <= k) {
                return true;
            }
            lastPositions.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII solution = new ContainsDuplicateII();
        System.out.println(solution.containsNearbyDuplicate(new int[] {1,2,3,1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[] {1,0,1,1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
        System.out.println(solution.containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 3));
    }
}
