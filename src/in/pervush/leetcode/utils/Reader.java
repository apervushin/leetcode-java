package in.pervush.leetcode.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public record StringTuple(String s1, String s2, String s3) {}

    public static List<StringTuple> read(final String file1Path, final String file2Path, final String file3Path) {
        try (final BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
             final BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));
             final BufferedReader reader3 = new BufferedReader(new FileReader(file3Path))) {

            String s1 = reader1.readLine();
            String s2 = reader2.readLine();
            String s3 = reader3.readLine();
            s1 = s1.substring(2, s1.length() - 2);
            s2 = s2.substring(2, s2.length() - 2);
            s3 = s3.substring(1, s3.length() - 1);
            final var s1Split = s1.split("\",\"", -1);
            final var s2Split = s2.split("],\\[", -1);
            final var s3Split = s3.split(",", -1);
            if (s1Split.length != s2Split.length || s1Split.length != s3Split.length) {
                throw new IllegalStateException(String.format("Lengths mismatch: %d != %d != %d",
                        s1Split.length, s2Split.length, s3Split.length));
            }

            final List<StringTuple> result = new ArrayList<>(s1Split.length);
            for (int i = 0; i < s1Split.length; ++i) {
                result.add(new StringTuple(s1Split[i], s2Split[i], s3Split[i]));
            }

            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
