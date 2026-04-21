class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] swap : allowedSwaps) {
            int rootA = find(parent, swap[0]);
            int rootB = find(parent, swap[1]);
            if (rootA != rootB) {
                parent[rootA] = rootB;
            }
        }
        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            if (!groups.containsKey(root)) {
                groups.put(root, new HashMap<>());
            }
            
            Map<Integer, Integer> valueCounts = groups.get(root);
            int val = source[i];
            if (valueCounts.containsKey(val)) {
                valueCounts.put(val, valueCounts.get(val) + 1);
            } else {
                valueCounts.put(val, 1);
            }
        }
        int distance = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> valueCounts = groups.get(root);
            int targetVal = target[i];
            if (valueCounts.containsKey(targetVal) && valueCounts.get(targetVal) > 0) {
                valueCounts.put(targetVal, valueCounts.get(targetVal) - 1);
            } else {
                distance++;
            }
        }
        return distance;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
}
