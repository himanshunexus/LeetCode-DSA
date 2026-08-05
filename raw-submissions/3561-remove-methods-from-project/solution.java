class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];
            adjList.get(u).add(v); 
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited[k] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neigh : adjList.get(curr)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        for (int[] arr : invocations){
            int u = arr[0];
            int v = arr[1];
            if(!visited[u] && visited[v]){
                List<Integer> allSafe = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    allSafe.add(i);
                }
                return allSafe;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!visited[i])
                res.add(i);
        }
        return res;
    }
}
