package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 */
public class ValidateBinaryTreeNodes {

    public static boolean validateBinaryTreeNodes(final int n, final int[] leftChild, final int[] rightChild) {
        // build uniq nodes
        final Set<Integer> nodes = IntStream.concat(
                Arrays.stream(leftChild),
                Arrays.stream(rightChild)
        ).filter(v -> v != -1).boxed().collect(Collectors.toUnmodifiableSet());

        // find potential root
        int root = -1;
        for (int i = 0; i < n; ++i) {
            if (!nodes.contains(i)) {
                root = i;
                break;
            }
        }
        if (root == -1) {
            return false;
        }

        // check all nodes accessible from root (only once)
        final Set<Integer> visited = new HashSet<>();
        final Queue<Integer> toVisit = new LinkedList<>();
        toVisit.add(root);
        while (!toVisit.isEmpty()) {
            int node = toVisit.poll();
            if (!visited.add(node)) {
                return false;
            }
            if (leftChild[node] != -1) {
                toVisit.add(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                toVisit.add(rightChild[node]);
            }
        }

        return visited.size() == n;
    }

    public static void main(String[] args) {
        System.out.println(validateBinaryTreeNodes(4, new int[] {1,-1,3,-1}, new int[] {2,-1,-1,-1}) + " (true)");
        System.out.println(validateBinaryTreeNodes(4, new int[] {1,-1,3,-1}, new int[] {2,3,-1,-1}) + " (false)");
        System.out.println(validateBinaryTreeNodes(6, new int[] {1,-1,-1,4,-1,-1}, new int[] {2,-1,-1,5,-1,-1}) + " (false)");
        System.out.println(validateBinaryTreeNodes(4, new int[] {3,-1,1,-1}, new int[] {-1,-1,0,-1}) + " (true)");
        System.out.println(validateBinaryTreeNodes(4, new int[] {1,0,3,-1}, new int[] {-1,-1,-1,-1}) + " (false)");
        System.out.println(validateBinaryTreeNodes(4, new int[] {1,2,0,-1}, new int[] {-1,-1,-1,-1}) + " (false)");
    }
}
