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
    int count = 0;
    public int max(TreeNode node){
        if(node == null) return 0;
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        int currMax = Math.max(node.val , Math.max(leftMax , rightMax));
        if(node.val == currMax){
            count++;
        }
        return currMax;
    }
    public int countDominantNodes(TreeNode root) {
        count = 0;
        max(root);
        return count;
    }
}
