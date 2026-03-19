class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m + 1][n + 1];
        int[][] x = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int val = 0;
                if (grid[i - 1][j - 1] == 'X') val = 1;
                else if (grid[i - 1][j - 1] == 'Y') val = -1;

                sum[i][j] = val + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];

                int addX = (grid[i - 1][j - 1] == 'X') ? 1 : 0;
                x[i][j] = addX + x[i - 1][j] + x[i][j - 1] - x[i - 1][j - 1];

                if (sum[i][j] == 0 && x[i][j] > 0) ans++;
            }
        }
        return ans;
    }
}
