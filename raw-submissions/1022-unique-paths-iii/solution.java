class Solution {
    private int totalPaths = 0;

    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0;
        int emptySquares = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    emptySquares++;
                }
            }
        }

        backtrack(grid, startX, startY, emptySquares + 1);
        return totalPaths;
    }

    private void backtrack(int[][] grid, int r, int c, int remain) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1) {
            return;
        }

        if (grid[r][c] == 2) {
            if (remain == 0) {
                totalPaths++;
            }
            return;
        }

        grid[r][c] = -1;

        backtrack(grid, r + 1, c, remain - 1);
        backtrack(grid, r - 1, c, remain - 1);
        backtrack(grid, r, c + 1, remain - 1);
        backtrack(grid, r, c - 1, remain - 1);

        grid[r][c] = 0;
    }
}
