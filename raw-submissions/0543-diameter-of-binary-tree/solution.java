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
    int maxDiameter = 0;
    private int levels(TreeNode root){
        if(root == null ) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        maxDiameter = Math.max(maxDiameter, leftLevels + rightLevels );
        return 1 + Math.max(leftLevels, rightLevels);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        levels(root);
        return maxDiameter;
    }
}
