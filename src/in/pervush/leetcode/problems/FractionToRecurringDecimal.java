package in.pervush.leetcode.problems;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class FractionToRecurringDecimal {

    public static String fractionToDecimal(long numerator, long denominator) {
        final List<String> result = new LinkedList<>();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.add("-");
        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        long a = numerator / denominator;
        long b = numerator % denominator;
        result.add(String.valueOf(a));

        if (numerator == a * denominator) {
            return String.join("", result);
        }

        result.add(".");

        final Map<Long, Integer> state = new LinkedHashMap<>();
        while (b != 0) {
            final var existingNumeratorPos = state.get(b);
            if (existingNumeratorPos != null) {
                result.add(existingNumeratorPos, "(");
                result.add(")");
                break;
            } else {
                state.put(b, result.size());
                b *= 10;
                a = b / denominator;
                b = b % denominator;
                result.add(String.valueOf(a));
            }
        }

        return String.join("", result);
    }

    public static void main(final String[] args) {
        System.out.println("-1 / -2147483648 = " + fractionToDecimal(-1, -2147483648));
        System.out.println("1 / 90 = " + fractionToDecimal(1, 90));
        System.out.println("1 / 17 = " + fractionToDecimal(1, 17));
        System.out.println("1751 / 25 = " + fractionToDecimal(1751, 25));
        System.out.println("1 / 2 = " + fractionToDecimal(1, 2));
        System.out.println("2 / 1 = " + fractionToDecimal(2, 1));
        System.out.println("4 / 333 = " + fractionToDecimal(4, 333));
    }
}
