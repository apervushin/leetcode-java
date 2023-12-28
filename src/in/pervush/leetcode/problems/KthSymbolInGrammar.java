package in.pervush.leetcode.problems;

import java.util.BitSet;

/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class KthSymbolInGrammar {

    public static int kthGrammar(final int n, final int k) {
        return kthGrammarRecursive(n, k, false) ? 1 : 0;
    }

    public static boolean kthGrammarRecursive(final int n, final int k, final boolean value) {
        if (n == 1) {
            return value;
        }
        final int nodesCnt = (int)Math.pow(2, n - 1);

        return nodesCnt / 2 < k ?
                kthGrammarRecursive(n - 1, k - (nodesCnt / 2), !value) :
                kthGrammarRecursive(n - 1, k, value);
    }

    public static int kthGrammarSlow(final int n, final int k) {
        final int size = (int)Math.pow(2, n - 1);
        final var state = new BitSet(size);

        for (int i = 1; i < n; ++i) {
            final int length = (int)Math.pow(2, n - i);
            final int nextLength = (int)Math.pow(2, n - i - 1);
            for (int j = 0; j < k; j += length) {
                state.set(j + nextLength, !state.get(j));
                if (j + nextLength == k - 1) {
                    return state.get(k - 1) ? 1 : 0;
                }
            }
        }

        return state.get(k - 1) ? 1 : 0;
    }

    public static void main(final String[] args) {
        System.out.println(kthGrammar(1,1) + " (0)");
        System.out.println(kthGrammar(2,1) + " (0)");
        System.out.println(kthGrammar(2,2) + " (1)");
        System.out.println(kthGrammar(3,2) + " (1)");
        System.out.println(kthGrammar(4,4) + " (0)");
        System.out.println(kthGrammar(30,434991989) + " (0)");
        System.out.println(kthGrammar(30,417219134) + " (1)");
    }
}
