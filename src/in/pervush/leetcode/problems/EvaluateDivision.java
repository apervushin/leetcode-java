package in.pervush.leetcode.problems;

import in.pervush.leetcode.utils.PrintUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision {

    public static double[] calcEquation(final List<List<String>> equations, final double[] values,
                                        final List<List<String>> queries) {
        final Map<String, Map<String, Double>> answers = new HashMap<>();
        final double[] results = new double[queries.size()];

        for (int i = 0; i < equations.size(); ++i) {
            final String first = equations.get(i).get(0);
            final String second = equations.get(i).get(1);
            final double answer = values[i];
            add(answers, first, second, answer);
        }

        for (int i = 0; i < queries.size(); ++i) {
            final String first = queries.get(i).get(0);
            final String second = queries.get(i).get(1);
            final var result = calculate(answers, first, second);
            results[i] = result == null ? -1.0 : result;
        }

        return results;
    }

    private static Double calculate(final Map<String, Map<String, Double>> graph, final String first,
                                    final String second) {
        final Set<String> visited = new HashSet<>();
        return calculate(graph, first, second, visited);
    }

    private static Double calculate(final Map<String, Map<String, Double>> graph, final String first,
                                    final String second, final Set<String> visited) {
        if (!visited.add(first)) {
            return null;
        }

        final var neighbours = graph.getOrDefault(first, Collections.emptyMap());
        for (final var neighbour : neighbours.entrySet()) {
            if (neighbour.getKey().equals(second)) {
                return neighbour.getValue();
            }
            final var result =
                    calculate(graph, neighbour.getKey(), second, visited);
            if (result != null) {
                final var result1 = result * neighbour.getValue();
                // optional cache
                add(graph, first, second, result1);
                return result1;
            }
        }

        return null;
    }

    private static void add(final Map<String, Map<String, Double>> graph, final String first, final String second,
                            final double answer) {
        addDirect(graph, first, second, answer);
        addDirect(graph, second, first, 1.0 / answer);
        addDirect(graph, first, first, 1.0);
        addDirect(graph, second, second, 1.0);
    }

    private static void addDirect(final Map<String, Map<String, Double>> answers, final String first,
                                  final String second, final double answer) {
        answers.compute(first, (k, v) -> {
            if (v == null) {
                v = new HashMap<>();
            }
            v.putIfAbsent(second, answer);
            return v;
        });
    }

    public static void main(final String[] args) {
        PrintUtils.print(calcEquation(
                List.of(List.of("a","b"), List.of("b","c")),
                new double[] {2.0, 3.0},
                List.of(List.of("a","c"), List.of("b","a"), List.of("a","e"), List.of("a","a"), List.of("x","x"))
        ));
    }
}
