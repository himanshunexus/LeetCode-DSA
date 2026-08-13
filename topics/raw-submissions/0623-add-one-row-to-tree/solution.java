class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        dfs(root, val, depth, 1);
        return root;
    }

    private void dfs(TreeNode root, int val, int depth, int current) {
        if (root == null) return;
        if (current == depth - 1) {
            TreeNode oldLeft = root.left;
            TreeNode oldRight = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = oldLeft;
            root.right.right = oldRight;
            return;
        }

        dfs(root.left, val, depth, current + 1);
        dfs(root.right, val, depth, current + 1);
    }
}
