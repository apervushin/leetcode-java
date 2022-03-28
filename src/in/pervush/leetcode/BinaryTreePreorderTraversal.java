package in.pervush.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        preorderTraversal(root.left, path);
        preorderTraversal(root.right, path);
    }
}
