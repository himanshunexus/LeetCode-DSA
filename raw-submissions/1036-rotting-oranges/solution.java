class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length , m = grid[0].length;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(grid[r][c] == 2){
                    dfs(grid , r , c , 2);
                }
            }
        }
        int time = 0; 
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(grid[r][c] == 1) return -1;
                if(grid[r][c] > 1)
                    time = Math.max(time , grid[r][c] - 2);
            }
        }
        return time;
    }
    private void dfs(int[][] grid, int r, int c, int minutes) {
        int n = grid.length, m = grid[0].length;
        
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0) return;
        if (grid[r][c] > 1 && grid[r][c] < minutes) return;
        
        grid[r][c] = minutes;
        
        dfs(grid, r - 1, c, minutes + 1);
        dfs(grid, r + 1, c, minutes + 1);
        dfs(grid, r, c - 1, minutes + 1);
        dfs(grid, r, c + 1, minutes + 1);
    }
}
