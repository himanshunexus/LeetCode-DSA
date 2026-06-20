class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int len = restrictions.length, height = 0, max = 0;
        if (len == 0) return n - 1;
        
        int[][] res = new int[len + 2][2];
        res[0] = new int[]{1, 0};
        res[1] = new int[]{n, n - 1};
        for (int i = 0; i < len; i++) {
            res[i + 2] = restrictions[i];
        }
        
        Arrays.sort(res, (a, b) -> a[0] - b[0]);
        
        int m = res.length;
        
        for (int i = 1; i < m; i++) {
            int dist = res[i][0] - res[i - 1][0];
            res[i][1] = Math.min(res[i][1], res[i - 1][1] + dist);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            int dist = res[i + 1][0] - res[i][0];
            res[i][1] = Math.min(res[i][1], res[i + 1][1] + dist);
        }
        
        for (int i = 1; i < m; i++) {
            int u = res[i - 1][0];
            int v = res[i][0];
            int h1 = res[i - 1][1];
            int h2 = res[i][1];
            
            height = (h1 + h2 + (v - u)) / 2;
            max = Math.max(max, height);
        }
        return max;
    }
}
