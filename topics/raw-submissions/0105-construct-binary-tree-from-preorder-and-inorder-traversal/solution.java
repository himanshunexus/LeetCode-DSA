class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] IDX = {0};
        return solve(preorder, inorder, 0, inorder.length - 1, IDX);
    }

    private TreeNode solve(int[] preorder, int[] inorder, int start, int end, int[] IDX) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[IDX[0]++];
        TreeNode root = new TreeNode(rootVal);

        int i = start;
        for (; i <= end; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }

        root.left = solve(preorder, inorder, start, i - 1, IDX);
        root.right = solve(preorder, inorder, i + 1, end, IDX);

        return root;
    }
}
