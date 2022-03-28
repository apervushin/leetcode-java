package in.pervush.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public static boolean canReach(final int[] arr, final int start) {
        final Queue<Integer> queue = new LinkedList<>();
        final boolean[] visited = new boolean[arr.length];
        queue.add(start);
        while (!queue.isEmpty()) {
            final int pos = queue.poll();
            if (visited[pos]) {
                continue;
            }
            if (arr[pos] == 0) {
                return true;
            }
            visited[pos] = true;
            final int beforePos = pos - arr[pos];
            if (beforePos >= 0) {
                queue.add(beforePos);
            }
            final int afterPos = pos + arr[pos];
            if (afterPos < arr.length) {
                queue.add(afterPos);
            }
        }

        return false;
    }

    private static void test1() {
        System.out.println(canReach(new int[]{4,2,3,0,3,1,2}, 5));
    }

    private static void test2() {
        System.out.println(canReach(new int[]{4,2,3,0,3,1,2}, 0));
    }

    private static void test3() {
        System.out.println(canReach(new int[]{3,0,2,1,2}, 2));
    }

    private static void test4() {
        System.out.println(canReach(new int[]{0,3,0,6,3,3,4}, 6));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
