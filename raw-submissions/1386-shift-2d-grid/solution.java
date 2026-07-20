class Solution {
    private void reverse(int[][] grid , int x , int y , int col){
        while(x < y){
            int row1 = x / col , col1 = x % col;
            int row2 = y / col , col2 = y % col;
            int temp = grid[row1][col1];
            grid[row1][col1] = grid[row2][col2];
            grid[row2][col2] = temp;
            x++;
            y--;
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;
        reverse(grid, 0, total - 1, n);
        reverse(grid, 0, k - 1, n);
        reverse(grid, k, total - 1, n);

        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            for (int val : row) listRow.add(val);
            result.add(listRow);
        }
        return result;
    }
}
