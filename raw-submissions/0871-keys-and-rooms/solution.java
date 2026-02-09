class Solution {
    private void bfs(int x, boolean[] vis,List<List<Integer>> rooms ){
        int n = rooms.size();
        vis[x] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(q.size() > 0){
            int front = q.remove();
            for(int key : rooms.get(front)){ 
                if(vis[key] == false){ 
                    q.add(key);
                    vis[key] = true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int count = 0;
        boolean[] vis = new boolean[n];
        bfs(0, vis, rooms);
        for(int k = 0; k < n; k++){
            if(vis[k]){
                count++;
            }
        }
        return count == n ? true : false;
    }
}
