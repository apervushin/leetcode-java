package in.pervush.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> state = new HashSet<>();
        for (int num : nums) {
            if (state.contains(num)){
                state.remove(num);
            } else {
                state.add(num);
            }
        }
        return state.iterator().next();
    }

}
