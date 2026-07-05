class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] vis;
    static Stack<Integer> st;
    static void dfs(int node){
        vis[node] = true;
        for(int nei : graph[node]){
            if(!vis[nei])
                dfs(nei);
        }
        st.push(node);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        vis = new boolean[numCourses];
        st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }

        int[] position = new int[numCourses];
        int pos = 0;
        while (!st.isEmpty()) {
            position[st.pop()] = pos++;
        }

        for (int[] pre : prerequisites) {
            if (position[pre[1]] >= position[pre[0]]) {
                return false;
            }
        }
        return true;
    }
}
