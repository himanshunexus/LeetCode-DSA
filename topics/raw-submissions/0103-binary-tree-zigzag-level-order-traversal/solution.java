class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();

                if (leftToRight) level.addLast(n.val);
                else level.addFirst(n.val);

                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
