class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
        if (!adj.containsKey(u)) {
            adj.put(u, new ArrayList<>());
        }
        adj.get(u).add(v);
        if (!adj.containsKey(v)) {
            adj.put(v, new ArrayList<>());
        }   
        adj.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        visited.add(source);
        queue.add(source);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) return true;
            if (adj.containsKey(current)) {
                for (int x : adj.get(current)) {
                    if (!visited.contains(x)) {
                        visited.add(x);
                        queue.add(x);
                    }
                }
            }
        }
        return false;
    }
}
