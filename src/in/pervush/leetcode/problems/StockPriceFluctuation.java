package in.pervush.leetcode.problems;

import in.pervush.leetcode.utils.Reader;

import java.util.TreeMap;
import java.util.TreeSet;

public class StockPriceFluctuation {

    private static class StockPrice {

        private static class StockItem {
            public final int timestamp;
            public final int price;

            private StockItem(int timestamp, int price) {
                this.timestamp = timestamp;
                this.price = price;
            }

            @Override
            public String toString() {
                return "{" + timestamp + ", " + price + '}';
            }
        }

        private final TreeMap<Integer, StockItem> records = new TreeMap<>();
        private final TreeSet<StockItem> recordsValues = new TreeSet<>((a, b) -> {
            int compare = Integer.compare(a.price, b.price);
            if (compare == 0) {
                return Integer.compare(a.timestamp, b.timestamp);
            }
            return compare;
        });

        public void update(int timestamp, int price) {
            final var stockItem = new StockItem(timestamp, price);
            final var removedStockItem = records.remove(stockItem.timestamp);
            if (removedStockItem != null) {
                if (!recordsValues.remove(removedStockItem)) {
                    throw new IllegalStateException(String.format("Value not found: %s", removedStockItem));
                }
            }
            records.put(stockItem.timestamp, stockItem);
            recordsValues.add(stockItem);
        }

        public int current() {
            return records.lastEntry().getValue().price;
        }

        public int maximum() {
            return recordsValues.last().price;
        }

        public int minimum() {
            return recordsValues.first().price;
        }
    }

    private static void test1() {
        final StockPrice solution = new StockPrice();
        solution.update(1,10);
        solution.update(2,5);
        System.out.println(solution.current());
        System.out.println(solution.maximum());
        solution.update(1,3);
        System.out.println(solution.maximum());
        solution.update(4,2);
        System.out.println(solution.minimum());
    }

    private static void test2() {
        final StockPrice solution = new StockPrice();
        final var inputs = Reader.read(
                "inputs/2034/1.1.txt",
                "inputs/2034/1.2.txt",
                "inputs/2034/1.result.txt"
        );
        for (int i = 1; i < inputs.size(); ++i) {
            final var input = inputs.get(i);
            int result;
            switch (input.s1()) {
                case "update" -> {
                    final var split = input.s2().split(",");
                    solution.update(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                }
                case "minimum" -> {
                    result = solution.minimum();
                    System.out.println(i + ": " + input.s1() + ": " + result + " (" + input.s3() + ")" + (result != Integer.parseInt(input.s3()) ? " !!!" : ""));
                }
                case "maximum" -> {
                    result = solution.maximum();
                    System.out.println(i + ": " + input.s1() + ": " + result + " (" + input.s3() + ")" + (result != Integer.parseInt(input.s3()) ? " !!!" : ""));
                }
                case "current" -> {
                    result = solution.current();
                    System.out.println(i + ": " + input.s1() + ": " + result + " (" + input.s3() + ")" + (result != Integer.parseInt(input.s3()) ? " !!!" : ""));
                }
                default -> throw new IllegalStateException(input.s1());
            }
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}
