package in.pervush.leetcode.problems;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-knight-moves/
 */
public class MinimumKnightMoves {

    private static final int MAX_X = 300;
    private static final int MAX_Y = 300;

    private record Coordinate(int x, int y, int movesCnt) {

        @Override
        public boolean equals(final Object o) {
            if (!(o instanceof Coordinate)) {
                return false;
            }

            return this.x() == ((Coordinate) o).x() && this.y() == ((Coordinate) o).y();
        }

    }

    public static int minKnightMoves(final int x, final int y) {
        final Queue<Coordinate> queue = new LinkedList<>();
        final BitSet visited = new BitSet(1_000_000);

        final var init = new Coordinate(0, 0, 0);
        visited.set(0);
        queue.add(init);

        while (!queue.isEmpty()) {
            final var c = queue.poll();
            if (c.x() == x && c.y() == y) {
                return c.movesCnt();
            }

            final var nextCoordinates = List.of(
                    new Coordinate(c.x() - 2, c.y() - 1, c.movesCnt() + 1),
                    new Coordinate(c.x() - 2, c.y() + 1, c.movesCnt() + 1),
                    new Coordinate(c.x() + 2, c.y() - 1, c.movesCnt() + 1),
                    new Coordinate(c.x() + 2, c.y() + 1, c.movesCnt() + 1),
                    new Coordinate(c.x() - 1, c.y() - 2, c.movesCnt() + 1),
                    new Coordinate(c.x() - 1, c.y() + 2, c.movesCnt() + 1),
                    new Coordinate(c.x() + 1, c.y() - 2, c.movesCnt() + 1),
                    new Coordinate(c.x() + 1, c.y() + 2, c.movesCnt() + 1)
            );

            for (final var nextCoordinate : nextCoordinates) {
                if (nextCoordinate.x() < -MAX_X || nextCoordinate.x() > MAX_X
                        || nextCoordinate.y() < -MAX_Y || nextCoordinate.y() > MAX_Y) {
                    continue;
                }
                final int pos = (nextCoordinate.x() + MAX_X) * 1000 + (nextCoordinate.y() + MAX_Y);
                if (!visited.get(pos)) {
                    queue.add(nextCoordinate);
                    visited.set(pos);
                }
            }

        }

        return -1;
    }

    public static void main(final String[] args) {
        System.out.println(minKnightMoves(2, 1));
        System.out.println(minKnightMoves(5, 5));
        System.out.println(minKnightMoves(2, 112));
        System.out.println(minKnightMoves(270, -21));
        System.out.println(minKnightMoves(300, 0));
    }
}
