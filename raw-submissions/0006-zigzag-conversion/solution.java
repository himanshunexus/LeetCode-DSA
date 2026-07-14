class Solution {
    public String convert(String s, int k) {
        int n = s.length();
        if(k <= 1 || n <= k) return s;
        int sIdx = 0;
        int cc = 0;
        char[][] grid = new char[k][n];
        while(sIdx < n){
            for(int r = 0; r < k; r++){
                if(sIdx < n){
                    grid[r][cc] = s.charAt(sIdx++);
                }
            }
            cc++;
            for(int r = k - 2; r >= 1; r--){
                if(sIdx < n){
                    grid[r][cc] = s.charAt(sIdx++);
                    cc++;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int r = 0; r < k; r++){
            for(int c = 0; c < cc; c++){
                if(grid[r][c] != '\u0000'){
                    ans.append(grid[r][c]);
                }
            }
        }
        return ans.toString();
    }
}
