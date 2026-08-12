class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int val : to_delete) {
            set.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();
        if (deleteHelper(root, set, forest) != null) {
            forest.add(root);
        }
        return forest;
    }

    private TreeNode deleteHelper(TreeNode node, Set<Integer> set, List<TreeNode> forest) {
        if (node == null) return null;

        node.left = deleteHelper(node.left, set, forest);
        node.right = deleteHelper(node.right, set, forest);

        if (set.contains(node.val)) {
            if (node.left != null) forest.add(node.left);
            if (node.right != null) forest.add(node.right);
            return null;
        }
        return node;
    }
}
