package in.pervush.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> existingElements = new HashSet<>();
        for (int num : nums) {
            if (!existingElements.add(num)) {
                return true;
            }
        }
        return false;
    }

}
