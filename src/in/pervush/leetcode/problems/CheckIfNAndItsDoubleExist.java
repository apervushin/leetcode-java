package in.pervush.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(final int[] arr) {
        final Map<Integer, Integer> counts = new HashMap<>(); // number -> count
        for (final int val : arr) {
            counts.compute(val, (k, v) -> v == null ? 1 : v + 1);
        }

        for (final var e : counts.entrySet()) {
            final var val = e.getKey();
            final var val2x = val * 2;

            final var cnt2x = counts.get(val2x);
            if (cnt2x != null && (val != val2x || cnt2x != 1)) {
                return true;
            }
        }

        return false;
    }

}
