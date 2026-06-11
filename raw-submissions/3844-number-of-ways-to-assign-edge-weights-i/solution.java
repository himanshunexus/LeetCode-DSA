class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0; 
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            maxDepth = Math.max(maxDepth, dist[u]);

            for (int v : graph.get(u)) {
                if (dist[v] == -1) { 
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
        }

        long ans = 1;
        int MOD = 1000000007;
        for (int i = 0; i < maxDepth - 1; i++) {
            ans = (ans * 2) % MOD;
        }
        return (int) ans;
    }
}
