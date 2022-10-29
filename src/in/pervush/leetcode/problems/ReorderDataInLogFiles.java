package in.pervush.leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class ReorderDataInLogFiles {

    /**
     * Merge sort
     */
    public static String[] reorderLogFiles(final String[] logs) {
        final int n = logs.length;
        int k = 0;
        int pow = (int)Math.pow(2, k);
        while (pow < n) {
            for (int i = 0; i + pow < n; i += pow * 2) {
                merge(logs, i, i + pow, Math.min(i + (pow * 2), n));
            }
            ++k;
            pow = (int)Math.pow(2, k);
        }

        return logs;
    }

    private static void merge(final String[] arr, int startIndex, final int middleIndex, final int endIndex) {
        final String[] copy = Arrays.copyOfRange(arr, startIndex, middleIndex);
        int i = 0;
        int j = middleIndex;
        while (i < copy.length || j < endIndex) {
            if (i == copy.length) {
                arr[startIndex++] = arr[j++];
            } else if (j == endIndex) {
                arr[startIndex++] = copy[i++];
            } else {
//                System.out.println(copy[i] + " " + (compareLogs(copy[i], arr[j]) < 0 ? "<" : ">") + " " + arr[j]);
                arr[startIndex++] = compareLogs(copy[i], arr[j]) > 0 ? arr[j++] : copy[i++];
            }
        }
    }

    private static int compareLogs(final String a, final String b) {
        final var aSplit = a.split(" ", 2);
        final var bSplit = b.split(" ", 2);

        final boolean aIsLetter = isLetterLog(a);
        final boolean bIsLetter = isLetterLog(b);

        if (aIsLetter && !bIsLetter) {
            return -1;
        }
        if (!aIsLetter && bIsLetter) {
            return 1;
        }
        if (!aIsLetter && !bIsLetter) {
            return -1;
        }
        int compare = aSplit[1].compareTo(bSplit[1]);
        if (compare == 0) {
            compare = aSplit[0].compareTo(bSplit[0]);
            return compare == 0 ? -1 : compare;
        }
        return compare;
    }

    /**
     * Stupid solution
     */
    public static String[] reorderLogFiles1(final String[] logs) {
        final int n = logs.length;
        final String[] result = new String[n];
        int resultPos = 0;

        for (String log : logs) {
            if (isLetterLog(log)) {
                result[resultPos++] = log;
            }
        }

        Arrays.sort(result, (a, b) -> {
            if (a == null) {
                return 1;
            }
            if (b == null) {
                return -1;
            }
            final var compare = a.substring(a.indexOf(' ')).compareTo(b.substring(b.indexOf(' ')));
            if (compare == 0) {
                return a.compareTo(b);
            }
            return compare;
        });

        for (String log : logs) {
            if (!isLetterLog(log)) {
                result[resultPos++] = log;
            }
        }

        return result;
    }

    private static boolean isLetterLog(final String record) {
        return record.matches("^.*\s.*[a-z]+");
    }

    public static void main(final String[] args) {
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
    }
}
