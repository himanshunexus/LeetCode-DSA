class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        int r = 0 , c = 0 , dir = 0;
        int v = 1;
        int[] dr = {0 , 1 , 0 , -1};
        int[] dc = {1 , 0 , -1 , 0};
        for(int i = 0; i < n * n; i++){
            ans[r][c] = v++;
            vis[r][c] = true;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nr >= n || nc < 0 || nc >= n || vis[nr][nc]){
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            r = nr;
            c = nc;
        }
        return ans;
    }
}
