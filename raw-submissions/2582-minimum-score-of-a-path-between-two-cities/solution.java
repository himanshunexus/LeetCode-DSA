class Solution {
    int minScore = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }
        boolean[] visited = new boolean[n + 1];
        dfs(1, graph, visited);
        return minScore;
    }

    private void dfs(int current, List<List<int[]>> graph, boolean[] visited) {
        if (visited[current] == true) {
            return;
        }
        visited[current] = true;
        for (int[] neighbor : graph.get(current)) {
            int nextCity = neighbor[0];
            int roadWeight = neighbor[1];
            if (roadWeight < minScore) {
                minScore = roadWeight;
            }
            dfs(nextCity, graph, visited);
        }
    }
}
