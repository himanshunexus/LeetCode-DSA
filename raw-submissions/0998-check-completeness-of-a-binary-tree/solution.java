/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private boolean isComplete(TreeNode root, int index, int totalNodes) {
        if (root == null) return true;
        if (index > totalNodes) return false;

        return isComplete(root.left, 2 * index, totalNodes)
            && isComplete(root.right, 2 * index + 1, totalNodes);
    }
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return isComplete(root, 1, totalNodes);
    }
}
