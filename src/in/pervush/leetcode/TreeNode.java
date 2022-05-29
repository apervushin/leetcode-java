package in.pervush.leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if (left != null && right != null) {
            return "{v=" + val + ", l=" + left + ", r=" + right + '}';
        } else if (left != null) {
            return "{v=" + val + ", l=" + left + '}';
        } else if (right != null) {
            return "{v=" + val + ", r=" + right + '}';
        }
        return "{v=" + val + '}';
    }
}