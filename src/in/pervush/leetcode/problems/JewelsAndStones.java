package in.pervush.leetcode.problems;

import java.util.BitSet;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {

    public static int numJewelsInStones(final String jewels, final String stones) {
        final var jewelsBitSet = new BitSet(57);

        for (int i = 0; i < jewels.length(); ++i) {
            jewelsBitSet.set(jewels.charAt(i) - 'A');
        }

        int result = 0;
        for (int i = 0; i < stones.length(); ++i) {
            if (jewelsBitSet.get(stones.charAt(i) - 'A')) {
                ++result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
