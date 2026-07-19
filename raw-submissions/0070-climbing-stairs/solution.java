class Solution {
    public int jump(int[] dp , int n){
        if(n == 1 || n == 2) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = jump(dp , n - 1) + jump(dp , n - 2);
    }
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int[] dp = new int[n + 1];
        return jump(dp , n);
    }
}
