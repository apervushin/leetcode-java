package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        String result = "";

        for (int i = num1.length() - 1; i >= 0; --i) {
            final int number1 = num1.charAt(i) - '0';
            final StringBuilder current = new StringBuilder();
            int plus = 0;

            current.append("0".repeat(Math.max(0, num1.length() - 1 - i)));

            for (int j = num2.length() - 1; j >= 0; --j) {
                final int number2 = num2.charAt(j) - '0';
                final int multiply = number1 * number2 + plus;
                current.append(multiply % 10);
                plus = multiply / 10;
            }
            current.append(plus);

            if (result.isEmpty()) {
                result = current.toString();
            } else {
                plus = 0;
                final StringBuilder nextResult = new StringBuilder();
                for (int l = 0; l < Math.max(result.length(), current.length()); ++l) {
                    final int n1 = result.length() > l ? result.charAt(l) - '0' : 0;
                    final int n2 = current.length() > l ? current.charAt(l) - '0' : 0;
                    final int sum = n1 + n2 + plus;
                    nextResult.append(sum % 10);
                    plus = sum / 10;
                }
                nextResult.append(plus);
                result = nextResult.toString();
            }

        }

        final StringBuilder reversedResult = new StringBuilder();
        boolean nonZeroReached = false;
        for (int i = result.length() - 1; i >= 0; --i) {
            if (result.charAt(i) == '0' && !nonZeroReached) {
                continue;
            }
            if (!nonZeroReached) {
                nonZeroReached = true;
            }
            reversedResult.append(result.charAt(i));
        }

        if (reversedResult.length() == 0) {
            reversedResult.append('0');
        }

        return reversedResult.toString();
    }

    private static void test1() {
        System.out.println(multiply("2", "3"));
    }

    private static void test2() {
        System.out.println(multiply("123", "456"));
    }

    private static void test3() {
        System.out.println(multiply("0", "0"));
    }

    private static void test4() {
        System.out.println(multiply("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
    }

    private static void test5() {
        System.out.println(multiply("1", "0"));
    }

    private static void test6() {
        System.out.println(multiply("0", "9"));
    }

    private static void test7() {
        System.out.println(multiply("8", "987654321"));
    }

    private static void test8() {
        //  121932631112635269
        System.out.println(multiply("123456789", "987654321"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
}
