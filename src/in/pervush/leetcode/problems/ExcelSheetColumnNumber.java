package in.pervush.leetcode.problems;

import java.util.Map;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

    public static int titleToNumber(final String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); ++i) {
            final char c = columnTitle.charAt(i);
            result = (result * 26) + (c - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("AZ"));
        System.out.println(titleToNumber("BA"));
        System.out.println(titleToNumber("ZZ"));
        System.out.println(titleToNumber("AAA"));
        System.out.println(titleToNumber("FXSHRXW"));
    }

}
