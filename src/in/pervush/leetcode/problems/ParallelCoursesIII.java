package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/parallel-courses-iii/
 */
public class ParallelCoursesIII {

    public static int minimumTime(final int n, final int[][] relations, final int[] time) {
        final Map<Integer, List<Integer>> todo = new HashMap<>();
        final Queue<Integer> progress = new LinkedList<>();
        final int[] endTms = new int[n];
        final int[] parentsCnt = new int[n];

        for (final var relation : relations) {
            relation[0]--;
            relation[1]--;

            todo.compute(relation[0], (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(relation[1]);
                return v;
            });

            parentsCnt[relation[1]]++;
        }

        for (int i = 0; i < n; ++i) {
            if (parentsCnt[i] == 0) {
                endTms[i] = time[i];
                progress.add(i);
            }
        }

        while (!progress.isEmpty()) {
            final var processedItemId = progress.poll();

            for (final var childId : todo.getOrDefault(processedItemId, Collections.emptyList())) {
                endTms[childId] = Math.max(endTms[processedItemId] + time[childId], endTms[childId]);
                if (--parentsCnt[childId] == 0) {
                    progress.add(childId);
                }
            }
        }

        return Arrays.stream(endTms).max().getAsInt();
    }

    public static void main(final String[] args) {
        System.out.println(minimumTime(3, new int[][] {{1,3},{2,3}}, new int[]{3,2,5}));
        System.out.println(minimumTime(5, new int[][] {{1,5},{2,5},{3,5},{3,4},{4,5}}, new int[]{1,2,3,4,5}));
    }
}
