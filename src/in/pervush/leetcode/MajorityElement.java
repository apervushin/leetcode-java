package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int resultPos = 0;
        int cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[resultPos] == nums[i]) {
                ++cnt;
            } else {
                --cnt;
            }
            if (cnt == 0) {
                resultPos = i;
                cnt = 1;
            }
        }
        return nums[resultPos];
    }

}
