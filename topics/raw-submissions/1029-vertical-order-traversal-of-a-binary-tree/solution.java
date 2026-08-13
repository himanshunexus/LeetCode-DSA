class Solution {
    static class Tuple {
        TreeNode node;
        int row; 
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeMap<Integer, PriorityQueue<Tuple>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode curr = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            if (!map.containsKey(col)) {
                map.put(col, new PriorityQueue<>((a, b) -> {
                    if (a.row != b.row) return Integer.compare(a.row, b.row);
                    return Integer.compare(a.node.val, b.node.val);
                }));
            }
            map.get(col).add(tuple);

            if (curr.left != null) {
                q.add(new Tuple(curr.left, row + 1, col - 1));
            }
            if (curr.right != null) {
                q.add(new Tuple(curr.right, row + 1, col + 1));
            }
        }

        for (PriorityQueue<Tuple> pq : map.values()) {
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll().node.val);
            }
            ans.add(list);
        }

        return ans;
    }
}
