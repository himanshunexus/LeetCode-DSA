class Solution {
    private int[] head;
    private int[] to;
    private int[] next;
    private int edgeCount;
    
    private int[] depth;
    private int[][] up;
    private int LOG;

    public void addEdge(int u, int v) {
        to[edgeCount] = v;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;
    }

    private void dfs(int node, int parent, int d) {
        depth[node] = d;
        up[node][0] = parent;
        for (int i = 1; i < LOG; i++) {
            up[node][i] = up[up[node][i - 1]][i - 1];
        }
        
        for (int e = head[node]; e != -1; e = next[e]) {
            int neighbor = to[e];
            if (neighbor != parent) {
                dfs(neighbor, node, d + 1);
            }
        }
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }
        
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = up[u][i];
            }
        }
        
        if (u == v) return u;
        
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }

    private long powerOfTwo(int exp, int mod) {
        long res = 1;
        long base = 2;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int MOD = 1000000007;
        
        LOG = 0;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        head = new int[n + 1];
        Arrays.fill(head, -1);
        to = new int[2 * n];
        next = new int[2 * n];
        edgeCount = 0;

        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);
        }

        depth = new int[n + 1];
        up = new int[n + 1][LOG];

        dfs(1, 1, 0);

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            if (u == v) {
                answer[i] = 0;
                continue;
            }
            
            int lca = getLCA(u, v);
            int pathLength = depth[u] + depth[v] - 2 * depth[lca];
            
            answer[i] = (int) powerOfTwo(pathLength - 1, MOD);
        }

        return answer;
    }
}
