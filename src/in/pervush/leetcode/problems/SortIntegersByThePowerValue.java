package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 */
public class SortIntegersByThePowerValue {

    private record NumberInfo (int x, int pow) implements Comparable<NumberInfo> {

        @Override
        public int compareTo(final NumberInfo o) {
            final int compare = Integer.compare(pow(), o.pow());
            return compare == 0 ? Integer.compare(x(), o.x()) : compare;
        }
    }

    private static final int MAX = 1000;
    private static final int[] STATE = new int[MAX * 3 + 1];

    static {
        Arrays.fill(STATE, -1);
    }

    public static int getKth(final int lo, final int hi, final int k) {
        final NumberInfo[] array = new NumberInfo[hi - lo + 1];
        for (int x = lo; x <= hi; ++x) {
            array[x - lo] = new NumberInfo(x, getPower(x));
        }
        Arrays.sort(array);
        return array[k - 1].x();
    }

    private static int getPower(final int x) {
        if (STATE[x] != -1) {
            return STATE[x];
        }
        int n = x;
        int cnt = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (3 * n) + 1;
            }
            cnt++;
        }

        return STATE[x] = cnt;
    }

    public static void main(final String[] args) {
        System.out.println(getKth(1, 1000, 100));
        System.out.println(getKth(12, 15, 2) + " (13)");
        System.out.println(getKth(7, 11, 4) + " (7)");
        System.out.println(getKth(1, 43, 40) + " (39)");
    }
}
