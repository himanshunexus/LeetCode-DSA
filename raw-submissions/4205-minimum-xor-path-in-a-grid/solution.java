class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer>[][] res = new HashSet[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = new HashSet<>();
            }
        }
        res[0][0].add(grid[0][0]);
        for(int j = 1; j < n; j++){
            for(int xor : res[0][j-1]){
                res[0][j].add(xor ^ grid[0][j]);
            }
        }
        for(int i = 1; i < m; i++){
            for(int xor : res[i-1][0]){
                res[i][0].add(xor ^ grid[i][0]);
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                for(int xor : res[i-1][j]){
                    res[i][j].add(xor ^ grid[i][j]);
                }
                for(int xor : res[i][j-1]){
                    res[i][j].add(xor ^ grid[i][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int xor : res[m-1][n-1]){
            ans = Math.min(ans,xor);
        }
        return ans;
    }
}
