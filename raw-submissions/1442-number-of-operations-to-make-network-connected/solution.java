class Solution {
    public int makeConnected(int n, int[][] connections) {
        int row = connections.length;
        if (row < n - 1) return -1;
        
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] e : connections) {
            int u = e[0];
            int v = e[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                canConnect(list, i, vis);
                res++;
            }
        }
        
        return res - 1;
    }
    
    public static void canConnect(ArrayList<ArrayList<Integer>> list, int node, boolean[] vis) {
        vis[node] = true;
        for (int neighbor : list.get(node)) {
            if (!vis[neighbor]) {
                canConnect(list, neighbor, vis);
            }
        }
    }
}
