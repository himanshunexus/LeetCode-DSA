class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[][] prefixSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currentSum = grid[i][j];
                if (i > 0) currentSum += prefixSum[i - 1][j];
                if (j > 0) currentSum += prefixSum[i][j - 1];
                if (i > 0 && j > 0) currentSum -= prefixSum[i - 1][j - 1];
                prefixSum[i][j] = currentSum; 
                if (currentSum <= k) {
                    count++;
                } else {
                    // 
                }
            }
        }
        return count;
    }
}

