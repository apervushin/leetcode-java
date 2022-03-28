package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {

    private static final char[] CHARS = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public String convertToTitle(int columnNumber) {
        final int length = CHARS.length;
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (columnNumber != 0) {
            int pos = columnNumber % length - 1;
            columnNumber /= length;
            if (pos == -1) {
                pos = length - 1;
                columnNumber--;
            }
            result.append(CHARS[pos]);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();
        int[] inputs = new int[]{1, 2, 25, 26, 27, 28, 52, 53};
        for (int i : inputs) {
            System.out.println(i + " " + solution.convertToTitle(i));
        }
    }

}
