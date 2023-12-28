package in.pervush.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */
public class MovingAverageFromDataStream {

    public static class MovingAverage {

        private final int maxSize;
        private final Queue<Integer> values = new LinkedList<>();
        private int currentSize;
        private int sum;

        public MovingAverage(final int maxSize) {
            this.maxSize = maxSize;
        }

        public double next(final int val) {
            if (currentSize == maxSize) {
                --currentSize;
                sum -= values.poll();
            }
            sum += val;
            ++currentSize;
            values.add(val);
            return (double)sum / (double) currentSize;
        }

    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }
}
