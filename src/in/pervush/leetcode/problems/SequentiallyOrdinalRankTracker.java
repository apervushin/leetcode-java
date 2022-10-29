package in.pervush.leetcode.problems;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/sequentially-ordinal-rank-tracker/
 */
public class SequentiallyOrdinalRankTracker {

    private static class SORTracker {

        private record Location(int score, String name) implements Comparable<Location> {

            @Override
            public int compareTo(final Location o) {
                int scoreCompare = Integer.compare(this.score, o.score);
                if (scoreCompare == 0) {
                    return this.name.compareTo(o.name) * -1;
                }
                return scoreCompare;
            }
        }

        private TreeSet<Location> notFetchedLocations = new TreeSet<>();
        private TreeSet<Location> fetchedLocations = new TreeSet<>();

        public void add(final String name, final int score) {
            final var location = new Location(score, name);
            final var minFetched = fetchedLocations.pollFirst();
            if (minFetched == null) {
                notFetchedLocations.add(location);
            } else if (minFetched.compareTo(location) < 0) {
                notFetchedLocations.add(minFetched);
                fetchedLocations.add(location);
            } else {
                fetchedLocations.add(minFetched);
                notFetchedLocations.add(location);
            }
        }

        public String get() {
            final var location = notFetchedLocations.pollLast();
            fetchedLocations.add(location);
            return location.name();
        }
    }

    private static void test1() {
        final var solution = new SORTracker();
        solution.add("test1", 1);
        solution.add("test3", 3);
        solution.add("test2", 1);

        System.out.println(solution.get());
        System.out.println(solution.get());
        System.out.println(solution.get());
    }

    private static void test2() {
        final var solution = new SORTracker();
        solution.add("bradford", 2);
        solution.add("branford", 3);
        System.out.println(solution.get());
        solution.add("alps", 2);
        System.out.println(solution.get());
        solution.add("orland", 2);
        System.out.println(solution.get());
        solution.add("orlando", 3);
        System.out.println(solution.get());
        solution.add("alpine", 2);
        System.out.println(solution.get());
        System.out.println(solution.get());
    }

    private static void test3() {
        final var solution = new SORTracker();
        solution.add("b",74);
        System.out.println(solution.get());
        solution.add("c",50);
        System.out.println(solution.get());
        solution.add("i",52);
        System.out.println(solution.get());
        solution.add("m",70);
        solution.add("f",81);
        System.out.println(solution.get());
        System.out.println(solution.get());
        solution.add("o",71);
        solution.add("k",47);
        System.out.println(solution.get());
        System.out.println(solution.get());
        solution.add("t",72);
        System.out.println(solution.get());
        solution.add("a",69);
        System.out.println(solution.get());
        solution.add("h",91);
        solution.add("v",61);
        solution.add("d",66);
        solution.add("z",38);
        System.out.println(solution.get());
        System.out.println(solution.get());
        System.out.println(solution.get());
        System.out.println(solution.get());
    }

    public static void main(String[] args) {
        test3();
    }
}
