package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public static int findLeastNumOfUniqueInts(final int[] arr, final int k) {
        final var sorted = Arrays.stream(arr).boxed()
                .collect(Collectors.toMap(Function.identity(), e -> 1L, Long::sum))
                .values().stream()
                .sorted()
                .collect(Collectors.toList());

//        System.out.println(sorted);

        long cnt = 0;
        for (int i = 0; i < sorted.size(); ++i) {
            cnt += sorted.get(i);
            if (cnt >= k) {
                return sorted.size() - i - (cnt == k ? 1 : 0);
            }
        }

        return -1;
    }

    public static void main(final String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[] {5,5,4}, 1) + " (1)");
        System.out.println(findLeastNumOfUniqueInts(new int[] {4,3,1,1,3,3,2}, 1) + " (3)");
    }
}
