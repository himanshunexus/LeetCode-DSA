class Solution {
    public int shortestPath(int n, int[][] edges, String s, int k) {
       List<int[]>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            g[e[0]].add(new int[]{e[1] , e[2]});
        }
        long[][] d = new long[n][k + 1];
        for(long[] r : d) Arrays.fill(r , Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[0],b[0]));
        d[0][1] = 0;
        pq.offer(new long[]{0,0,1});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            long dis = cur[0];
            int u = (int) cur[1] , c = (int)cur[2];
            if(dis != d[u][c]) continue;
            if(u == n - 1) return (int)dis;

            for(int[] e : g[u]){
                int v = e[0] , nc = s.charAt(u) == s.charAt(v) ? c + 1 : 1;
                if(nc > k) continue;

                long nd = dis + e[1];
                if(nd < d[v][nc]){
                    d[v][nc] = nd;
                    pq.offer(new long[]{nd , v , nc});
                }
            }
        }
        return -1;
    }
}
