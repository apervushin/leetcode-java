package in.pervush.leetcode.problems;

import in.pervush.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description
 */
public class FindLargestValueInEachTreeRow {

    public static List<Integer> largestValues(final TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        largestValues(root, result, 0);
        return result;
    }

    public static void largestValues(final TreeNode root, final List<Integer> result, final int depth) {
        if (root == null) {
            return;
        }
        if (result.size() - 1 < depth) {
            result.add(root.val);
        } else {
            result.set(depth, Math.max(result.get(depth), root.val));
        }
        largestValues(root.left, result, depth + 1);
        largestValues(root.right, result, depth + 1);
    }
}
