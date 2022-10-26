package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode.com/problems/analyze-user-website-visit-pattern/
 */
public class AnalyzeUserWebsiteVisitPattern {

    private static class Pattern implements Comparable<Pattern> {
        public final String s1;
        public final String s2;
        public final String s3;

        public Pattern(String s1, String s2, String s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pattern pattern = (Pattern) o;

            return Objects.equals(s1, pattern.s1) && Objects.equals(s2, pattern.s2) &&  Objects.equals(s3, pattern.s3);
        }

        @Override
        public int hashCode() {
            int result = s1 != null ? s1.hashCode() : 0;
            result = 31 * result + (s2 != null ? s2.hashCode() : 0);
            result = 31 * result + (s3 != null ? s3.hashCode() : 0);
            return result;
        }


        @Override
        public int compareTo(final Pattern o) {
            int compare = this.s1.compareTo(o.s1);
            if (compare != 0) {
                return compare;
            }

            compare = this.s2.compareTo(o.s2);
            if (compare != 0) {
                return compare;
            }

            return this.s3.compareTo(o.s3);
        }

        @Override
        public String toString() {
            return "{" + s1 + ", " + s2 + ", " + s3 + '}';
        }
    }

    private record Visit(String website, int timestamp) {

        @Override
        public String toString() {
            return "{" + website + ", " + timestamp + '}';
        }

    }

    public static List<String> mostVisitedPattern(final String[] username, final int[] timestamp,
                                                  final String[] website) {
        final Map<String, List<Visit>> userVisits = new HashMap<>();
        for (int i = 0; i < username.length; ++ i) {
            final String w = website[i];
            final int t = timestamp[i];
            userVisits.compute(username[i], (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(new Visit(w, t));
                return v;
            });
        }

        final Map<Pattern, Set<String>> state = new HashMap<>(); // Pattern -> set of usernames
        for (final var e : userVisits.entrySet()) {
            final var visits = e.getValue();
            visits.sort(Comparator.comparingInt(Visit::timestamp));

            for (int i = 0; i < visits.size(); ++i) {
                for (int j = i + 1; j < visits.size(); ++j) {
                    for (int k = j + 1; k < visits.size(); ++k) {
                        state.compute(
                                new Pattern(visits.get(i).website, visits.get(j).website, visits.get(k).website),
                                (key, val) -> {
                                    if (val == null) {
                                        val = new HashSet<>();
                                    }
                                    val.add(e.getKey());
                                    return val;
                                }
                        );
                    }
                }
            }
        }

        final Pattern mostFeqPattern = state.entrySet().stream()
                .max((a, b) -> {
                    final int compare = Integer.compare(a.getValue().size(), b.getValue().size());
                    if (compare == 0) {
                        return a.getKey().compareTo(b.getKey()) * -1;
                    }
                    return compare;
                }).get().getKey();

        return List.of(mostFeqPattern.s1, mostFeqPattern.s2, mostFeqPattern.s3);
    }

    public static void main(final String[] args) {
        System.out.println(mostVisitedPattern(
                new String[] {"joe","joe","joe","james","james","james","james","mary","mary","mary"},
                new int[] {1,2,3,4,5,6,7,8,9,10},
                new String[] {"home","about","career","home","cart","maps","home","home","about","career"}
        ));
        System.out.println(mostVisitedPattern(
                new String[] {"ua","ua","ua","ub","ub","ub"},
                new int[] {1,2,3,4,5,6},
                new String[] {"a","b","a","a","b","c"}
        ));
        System.out.println(mostVisitedPattern(
                new String[] {"zkiikgv","zkiikgv","zkiikgv","zkiikgv"},
                new int[] {436363475,710406388,386655081,797150921},
                new String[] {"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"}
        ) + " ([oz,mryxsjc,wlarkzzqht])");
        System.out.println(mostVisitedPattern(
                new String[] {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"},
                new int[] {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930},
                new String[] {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"}
        ) + " ([hibympufi,hibympufi,yljmntrclw])");
    }
}
