package in.pervush.leetcode.problems;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/rle-iterator/description/
 */
public class RLEIterator {

    private final int[] values;
    private final long[] counts;
    private long fetchedCnt = 0;
    private int pos = 0;

    public RLEIterator(final int[] encoding) {
        this.values = new int[encoding.length / 2];
        this.counts = new long[encoding.length / 2];
        int zeroCnt = 0;
        for (int i = 0; i < encoding.length; i += 2) {
            if (encoding[i] > 0) {
                this.counts[i / 2 - zeroCnt] = encoding[i] + (i == 0 ? 0 : this.counts[i / 2 - 1 - zeroCnt]);
                this.values[i / 2 - zeroCnt] = encoding[i + 1];
            } else {
                ++zeroCnt;
            }
        }
    }

    public int next(final int n) {
        fetchedCnt += n;
        int searchPos = Arrays.binarySearch(counts, this.pos, counts.length, fetchedCnt);
        if (searchPos < 0) {
            searchPos = searchPos * -1 - 1;
        }
        if (searchPos >= counts.length) {
            return -1;
        }
        pos = searchPos;

        return values[searchPos];
    }

    public static void test1() {
        final RLEIterator solution = new RLEIterator(new int[] {3,8,0,9,2,5});
        System.out.println(solution.next(2) + " (8)");  // 1 8 0 9 2 5
        System.out.println(solution.next(1) + " (8)");  // 0 8 0 9 2 5
        System.out.println(solution.next(1) + " (5)");  // 0 8 0 9 1 5
        System.out.println(solution.next(2) + " (-1)"); // 0 8 0 9 0 5
    }

    public static void test2() {
        final var start = Instant.now();
        final RLEIterator solution = new RLEIterator(new int[] {923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82});
        System.out.println(solution.next(612783106) + " (?)");
        System.out.println(solution.next(486444202) + " (?)");
        System.out.println(solution.next(630147341) + " (?)");
        System.out.println(solution.next(845077576) + " (?)");
        System.out.println(solution.next(243035623) + " (?)");
        System.out.println(solution.next(731489221) + " (?)");
        System.out.println(solution.next(117134294) + " (?)");
        System.out.println(solution.next(220460537) + " (?)");
        System.out.println(solution.next(794582972) + " (?)");
        System.out.println(solution.next(332536150) + " (?)");
        System.out.println(solution.next(815913097) + " (?)");
        System.out.println(solution.next(100607521) + " (?)");
        System.out.println(solution.next(146358489) + " (?)");
        System.out.println(solution.next(697670641) + " (?)");
        System.out.println(solution.next(45234068) + " (?)");
        System.out.println(solution.next(573866037) + " (?)");
        System.out.println(solution.next(519323635) + " (?)");
        System.out.println(solution.next(27431940) + " (?)");
        System.out.println(solution.next(16279485) + " (?)");
        System.out.println(solution.next(203970) + " (?)");
        System.out.println(Duration.between(start, Instant.now()));
    }

    public static void main(final String[] args) {
        test1();
        test2();
    }

}
