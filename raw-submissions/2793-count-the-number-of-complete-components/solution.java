class Solution {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                boolean isComplete = true;
                int k = component.size();
                for (int node : component) {
                    if (degree[node] < k - 1) {
                        isComplete = false;
                        break;
                    }
                }
                if (isComplete) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
    }
}
