package in.pervush.leetcode.problems;

public class FindTheCelebrity {

    public static class Relation {

        private final int[][] graph;

        public Relation(final int[][] graph) {
            this.graph = graph;
        }

        public boolean knows(final int a, final int b) {
            return graph[a][b] == 1;
        }
    }

    public static class Solution extends Relation {

        public Solution(final int[][] graph) {
            super(graph);
        }

        public int findCelebrity(final int n) {
            int candidate = 0;

            for (int i = 0; i < n; ++i) {
                if (knows(candidate, i)) {
                    candidate = i;
                }
            }

            for (int i = 0; i < n; ++i) {
                if (candidate == i) { continue; }
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }

            return candidate;
        }

    }

    public static void test1() {
        final var input = new int[][] {
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0}
        };
        final Solution s = new Solution(input);
        System.out.println(s.findCelebrity(input.length) + " (1)");
    }

    public static void test2() {
        final var input = new int[][] {
                {1,0},
                {0,1}
        };
        final Solution s = new Solution(input);
        System.out.println(s.findCelebrity(input.length) + " (-1)");
    }

    public static void test3() {
        final var input = new int[][] {
                {1,1},
                {1,1}
        };
        final Solution s = new Solution(input);
        System.out.println(s.findCelebrity(input.length) + " (-1)");
    }

    public static void test4() {
        final var input = new int[][] {
                {1,1,1},
                {1,1,0},
                {0,0,1}
        };
        final Solution s = new Solution(input);
        System.out.println(s.findCelebrity(input.length) + " (-1)");
    }

    public static void main(final String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
