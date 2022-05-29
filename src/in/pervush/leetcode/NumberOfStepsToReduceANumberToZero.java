package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/submissions/
 */
public class NumberOfStepsToReduceANumberToZero {

    private static final int AND = Integer.MAX_VALUE - 1;

    public static int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num &= AND;
            }
            ++cnt;
        }
        return cnt;
    }

    private static void test1() {
        System.out.println(numberOfSteps(14));;
    }

    private static void test2() {
        System.out.println(numberOfSteps(8));;
    }

    private static void test3() {
        System.out.println(numberOfSteps(123));;
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
