class Solution {
    static Boolean dp[][];
    public static boolean solve(String s , int i , int j){
        if(i >= j) return true;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == s.charAt(j))  return dp[i][j] = solve(s ,  i + 1, j - 1);
        return dp[i][j] = false;
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        dp = new Boolean[n][n];
        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(solve(s , i , j) == true){
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        count = i;
                    }
                }
            }
        }
        return s.substring(count , count + max);
    }
}
