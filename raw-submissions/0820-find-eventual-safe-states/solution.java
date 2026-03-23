class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; 
        List<List<Integer>> reversedGraph = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }
        for (int node = 0; node < n; node++) {
            for (int neighbor : graph[node]) {
                reversedGraph.get(neighbor).add(node);
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        boolean[] safe = new boolean[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;
            for (int neighbor : reversedGraph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }
        return result;
    }
}

