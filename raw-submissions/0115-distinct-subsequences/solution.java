class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length() , m = t.length();
        long[][] res = new long[n+1][m+1];
        for(int i = 0; i <= n; i++)
            res[i][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i -1 ) == t.charAt(j -1)){
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
                }else{
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return (int)res[n][m];
    }
}
