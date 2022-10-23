package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static String convert(final String s, final int numRows) {
        if (numRows == 1) {
            return s;
        }
        final List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; ++i) {
            rows.add(new StringBuilder());
        }

        int rowNumber = 0;
        boolean increase = true;
        for (int i = 0; i < s.length(); ++i) {
            rows.get(rowNumber).append(s.charAt(i));
            rowNumber += increase ? 1 : -1;
            if (rowNumber == numRows || rowNumber == -1) {
                increase = !increase;
                rowNumber += increase ? 2 : -2;
            }
        }

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            result.append(rows.get(i));
        }
        return result.toString();
    }

    private static void test1() {
        final String input = "PAYPALISHIRING";
        final int rowsCnt = 3;
        System.out.println(input + ", " + rowsCnt);
        final String result = convert(input, rowsCnt);
        System.out.println(result);
        System.out.println();
    }

    private static void test2() {
        final String input = "AB";
        final int rowsCnt = 1;
        System.out.println(input + ", " + rowsCnt);
        final String result = convert(input, rowsCnt);
        System.out.println(result);
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
