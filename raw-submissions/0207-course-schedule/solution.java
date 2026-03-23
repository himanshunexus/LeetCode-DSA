class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                if (hasCycle(i, adj, visit)) {
                    return false; 
                }
            }
        }
        return true;
    }
    private boolean hasCycle(int node, List<List<Integer>> adj, int[] visit) {
        if (visit[node] == 1) return true; 
        if (visit[node] == 2) return false;

        visit[node] = 1; 
        
        for (int neighbor : adj.get(node)) {
            if (hasCycle(neighbor, adj, visit)) {
                return true;
            }
        }
        visit[node] = 2;
        return false;
    }
}
