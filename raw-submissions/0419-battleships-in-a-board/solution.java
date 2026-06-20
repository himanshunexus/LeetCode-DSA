class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length , m = board[0].length;
        int count = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(board[r][c] == 'X'){
                    dfs(board , r , c);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid , int r , int c) {
        int n = grid.length , m = grid[0].length;
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == '.') return;

        grid[r][c] = '.';
        dfs(grid , r + 1 , c);
        dfs(grid , r - 1 , c);
        dfs(grid , r , c + 1);
        dfs(grid , r , c - 1);
    }
}
