class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        int[] visit = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                if (hasCycle(i, adj, visit, stack)) {
                    return new int[0]; 
                }
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
    private boolean hasCycle(int node, List<List<Integer>> adj, int[] visit, Stack<Integer> stack) {
        visit[node] = 1; 
        for (int neighbor : adj.get(node)) {
            if (visit[neighbor] == 1) return true; 
            if (visit[neighbor] == 0) {
                if (hasCycle(neighbor, adj, visit, stack)) return true;
            }
        }
        visit[node] = 2;
        stack.push(node);
        return false;
    }
}
