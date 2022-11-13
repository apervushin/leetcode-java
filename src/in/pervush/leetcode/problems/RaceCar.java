package in.pervush.leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/race-car/solutions/
 * Implemented as BFS. BFS approach complexity: O(target * log(target))
 * Other DP approach explanation: https://www.youtube.com/watch?v=DBJPWJr5zZ4
 */
public class RaceCar {

    private record Pos(int pos, int speed, int stepsCnt) implements Comparable<Pos> {

        @Override
        public int compareTo(final Pos o) {
            final int compare = Integer.compare(this.pos, o.pos);
            if (compare == 0) {
                return Integer.compare(this.speed, o.speed);
            }
            return compare;
        }
    }

    public static int racecar(final int target) {
        final Set<Pos> visited = new HashSet<>();
        final Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 1, 0));
        while (!queue.isEmpty()) {
            final var pos = queue.poll();

            //System.out.println(pos);

            if (pos.pos() == target) {
                return pos.stepsCnt();
            } else if (!visited.contains(pos)) {
                visited.add(pos);
                int nextPos = pos.pos() + pos.speed();
                queue.add(new Pos(nextPos, pos.speed() * 2, pos.stepsCnt() + 1));
                if ((pos.speed() < 0 && nextPos < target) || (pos.speed() > 0 && nextPos > target)) {
                    queue.add(new Pos(pos.pos(), pos.speed() < 0 ? 1 : -1, pos.stepsCnt() + 1));
                }
            }
        }

        return -1;
    }

    public static void main(final String[] args) {
        System.out.println("1: " + racecar(1) + " (1)");
        System.out.println("2: " + racecar(2) + " (4)");
        System.out.println("3: " + racecar(3) + " (2)");
        System.out.println("4: " + racecar(4) + " (5)");
        System.out.println("5: " + racecar(5) + " (7)");
        System.out.println("6: " + racecar(6) + " (5)");
    }
}
