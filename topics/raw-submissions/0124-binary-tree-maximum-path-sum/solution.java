class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return ans;
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;

        int lefts = Math.max(0, sum(root.left));
        int rights = Math.max(0, sum(root.right));

        ans = Math.max(ans, root.val + lefts + rights);

        return root.val + Math.max(lefts, rights);
    }
}
