package in.pervush.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 */
public class FillingBookcaseShelves {

    private record Key(int pos, int h, int w) implements Comparable<Key> {
        @Override
        public int compareTo(Key o) {
            int compare = Integer.compare(this.pos, o.pos);
            if (compare != 0) {
                return compare;
            }
            compare = Integer.compare(this.h, o.h);
            if (compare != 0) {
                return compare;
            }
            return Integer.compare(this.w, o.w);
        }
    }

    public static int minHeightShelves(final int[][] books, final int shelfWidth) {
        final Map<Key, Integer> state = new HashMap<>();
        return minHeightShelves(books, shelfWidth, state, 0, 0, 0);
    }

    private static int minHeightShelves(final int[][] books, final int shelfWidth, final Map<Key, Integer> state,
                                        final int pos, final int currentHeight, final int currentWidth) {
        if (pos == books.length) {
            return currentHeight;
        }
        final var book = books[pos];
        final var key = new Key(pos, currentHeight, currentWidth);
        final var cachedResult = state.get(key);
        if (cachedResult != null) {
            return cachedResult;
        }

        int result = Integer.MAX_VALUE;
        if (currentWidth + book[0] <= shelfWidth) {
            result = minHeightShelves(books, shelfWidth, state, pos + 1, Math.max(currentHeight, book[1]),
                    currentWidth + book[0]);
        }
        result = Math.min(
                minHeightShelves(books, shelfWidth, state, pos + 1, book[1], book[0]) + currentHeight,
                result
        );

        state.put(key, result);
        return result;
    }

    public static void main(final String[] args) {
        System.out.println(minHeightShelves(new int[][] {
                new int[] {1,1},
                new int[] {2,3},
                new int[] {2,3},
                new int[] {1,1},
                new int[] {1,1},
                new int[] {1,1},
                new int[] {1,2}
        }, 4));
    }
}
