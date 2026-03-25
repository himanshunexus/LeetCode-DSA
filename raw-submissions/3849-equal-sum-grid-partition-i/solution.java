class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += (long) grid[i][j];
            }
        }
        if (totalSum % 2 != 0) return false;
        long target = totalSum / 2;
        long currentRowsSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                currentRowsSum += (long) grid[i][j];
            }
            if (currentRowsSum == target) return true;
        }
        long currentColSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                currentColSum += (long) grid[i][j];
            }
            if (currentColSum == target) return true;
        }
        return false;
    }
}


