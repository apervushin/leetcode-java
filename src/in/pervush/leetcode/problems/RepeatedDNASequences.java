package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDNASequences {

    private static class SlidingFixedLengthDNASequenceHash {

        private static final int ALPHABET_SIZE_BITS = 2;
        private final int length;
        private final int andPart;
        private int hash = 0;

        public SlidingFixedLengthDNASequenceHash(final int length) {
            this.length = length;
            this.andPart = getAndPart(length);
        }

        public int buildInitialHash(final String s) {
            if (s.length() != length) {
                throw new IllegalArgumentException(String.format("s length != %d (== %d)", length, s.length()));
            }
            hash = 0;
            for (int i = 0; i < length; ++i) {
                hash = hash << ALPHABET_SIZE_BITS;
                hash |= getI(s.charAt(i));
            }

            return hash;
        }

        public int buildNextHash(final char newSymbol) {
            hash <<= ALPHABET_SIZE_BITS;
            hash &= andPart;
            hash |= getI(newSymbol);
            return hash;
        }

        private static int getAndPart(final int length) {
            int result = Integer.MAX_VALUE;
            result >>= (Integer.SIZE - (length * ALPHABET_SIZE_BITS) - 1);
            return result;
        }

        private static int getI(final char c) {
            switch (c) {
                case 'A':
                    return 0; // 00
                case 'C':
                    return 1; // 01
                case 'G':
                    return 2; // 10
                case 'T':
                    return 3; // 11
                default:
                    throw new IllegalArgumentException(String.format("Unknown char: %s", c));
            }
        }
    }

    private static final int LENGTH = 10;

    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < LENGTH) {
            return Collections.emptyList();
        }
        final Map<Integer, Integer> state = new HashMap<>();
        final List<String> result = new ArrayList<>();
        final var hash = new SlidingFixedLengthDNASequenceHash(LENGTH);
        state.put(hash.buildInitialHash(s.substring(0, LENGTH)), 1);
        for (int i = LENGTH; i < s.length(); ++i) {
            final Integer compute = state.compute(hash.buildNextHash(s.charAt(i)), (k, v) -> v == null ? 1 : v + 1);
            if (compute == 2) {
                result.add(s.substring(i - LENGTH + 1, i + 1));
            }
        }

        return result;
    }

    private static void test0() {
        System.out.println(findRepeatedDnaSequences("TTTTTTTTTTTT"));
    }

    private static void test1() {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    private static void test2() {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    private static void test3() {
        System.out.println(findRepeatedDnaSequences("A"));
    }

    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
    }
}
