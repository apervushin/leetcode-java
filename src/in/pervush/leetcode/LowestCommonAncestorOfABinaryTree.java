package in.pervush.leetcode;

import in.pervush.leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {

    private TreeNode result;

    private boolean lowestCommonAncestorRecursive(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null) {
            return false;
        }
        int result = root.equals(p) || root.equals(q) ? 1 : 0;

        result += lowestCommonAncestorRecursive(root.left, p, q) ? 1 : 0;
        result += lowestCommonAncestorRecursive(root.right, p, q) ? 1 : 0;

        if (result == 2) {
            this.result = root;
        }
        return result > 0;
    }

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        lowestCommonAncestorRecursive(root, p, q);
        return this.result;
    }

    public static void main(final String[] args) {
        final LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode root = new TreeNode(3);
        root.left = p;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = q;
        final var result = solution.lowestCommonAncestor(root, p, q);
        System.out.println(result);
    }
}
