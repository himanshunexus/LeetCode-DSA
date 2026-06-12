class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] > 0) max = Math.max(max, dfs(grid, r, c));
        return max;
    }

    private int dfs(int[][] g, int r, int c) {
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] == 0) return 0;
        int val = g[r][c];
        g[r][c] = 0;
        int max = Math.max(Math.max(dfs(g, r + 1, c), dfs(g, r - 1, c)), Math.max(dfs(g, r, c + 1), dfs(g, r, c - 1)));
        g[r][c] = val;
        return val + max;
    }
}
