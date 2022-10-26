package in.pervush.leetcode.problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * https://leetcode.com/problems/count-days-spent-together/
 */
public class CountDaysSpentTogether {

    private static String YEAR = "2022";

    public static int countDaysTogether(final String arriveAlice, final String leaveAlice, final String arriveBob,
                                        final String leaveBob) {
        final LocalDate arriveAliceDt = LocalDate.parse(YEAR + "-" + arriveAlice);
        final LocalDate leaveAliceDt = LocalDate.parse(YEAR + "-" + leaveAlice);
        final LocalDate arriveBobDt = LocalDate.parse(YEAR + "-" + arriveBob);
        final LocalDate leaveBobDt = LocalDate.parse(YEAR + "-" + leaveBob);

        final var maxArriveDt = max(arriveAliceDt, arriveBobDt);
        final var minLeaveDt = min(leaveAliceDt, leaveBobDt);

        return (int) Math.max(ChronoUnit.DAYS.between(maxArriveDt, minLeaveDt) + 1, 0);
    }

    private static LocalDate max(final LocalDate a, final LocalDate b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    private static LocalDate min(final LocalDate a, final LocalDate b) {
        return a.compareTo(b) < 0 ? a : b;
    }

    public static void main(final String[] args) {
        System.out.println(countDaysTogether("08-15", "08-18", "08-16", "08-19"));
        System.out.println(countDaysTogether("10-01", "10-31", "11-01", "12-31"));
    }
}
