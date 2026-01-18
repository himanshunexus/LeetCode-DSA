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
    public static void inorder(TreeNode root, ArrayList<TreeNode> arr) {
        if (root == null) return;
        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }
    public TreeNode bstToGst(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        inorder(root, arr);
        Collections.reverse(arr);
        int sum = 0;
        for (TreeNode node : arr) {
            sum += node.val;
            node.val = sum;
        } 
        return root;
    }
}
