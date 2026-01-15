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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, result, targetSum);
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> path, 
                     List<List<Integer>> result, int sum) {
        if (root == null) return;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(path));
        }
        
        dfs(root.left, path, result, sum - root.val);
        dfs(root.right, path, result, sum - root.val);
        
        path.remove(path.size() - 1);
    }
}
