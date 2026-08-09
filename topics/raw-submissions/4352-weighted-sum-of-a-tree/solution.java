class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length, h = 0;
        int[] depth = new int[n];
        depth[0] = 1;
        for (int i = 0; i < n; i++) {
            h = Math.max(h, getDepth(i, parent, depth));
        }
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += (long) nums[i] * (h - depth[i] + 1);
        }
        return totalSum;
    }

    private int getDepth(int i, int[] parent, int[] depth) {
        if (i == 0) return 1;
        if (depth[i] == 0) {
            depth[i] = 1 + getDepth(parent[i], parent, depth);
        }
        return depth[i];
    }
}
