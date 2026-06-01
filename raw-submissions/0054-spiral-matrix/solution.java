class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        boolean[][] vis = new boolean[R][C];

        int[] dr = {0,  1,  0, -1};
        int[] dc = {1,  0, -1,  0};

        int r = 0, c = 0, dir = 0;  

        for (int i = 0; i < R * C; i++) {
            res.add(matrix[r][c]);
            vis[r][c] = true;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C || vis[nr][nc]) {
                dir = (dir + 1) % 4;   
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
        }
        return res;
    }
}
