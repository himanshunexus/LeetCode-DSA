class Solution {
    private void levelOrder(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) return;
        if (ans.size() <= level) {
            ans.add(new ArrayList<>());
        }
        if (level % 2 == 0)
            ans.get(level).add(root.val); 
        else
            ans.get(level).add(0, root.val);  

        levelOrder(root.left, level + 1, ans);
        levelOrder(root.right, level + 1, ans);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, 0, ans);
        return ans;
    }
}
