class Solution {
    private void bfs(int x, boolean[] vis, int[][] adj){
        int n = adj.length;
        vis[x] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(q.size() > 0){
            int front = q.poll();
            for(int z = 0; z < n; z++){
                if(adj[front][z] == 1 && vis[z] == false){
                    q.add(z);
                    vis[z] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int k =0; k < n; k++){
            if(!vis[k]){
                bfs(k,vis,adj);
                count++;
            }
        }
        return count;
    }
}
