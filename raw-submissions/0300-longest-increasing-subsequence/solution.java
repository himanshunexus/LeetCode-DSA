class Solution {
    int n;
    int[][] dp;
    public int solve(int[] nums , int i , int p){
        if (i >= n) return 0;
        int pIdx = p + 1;
        if (dp[i][pIdx] != -1) {
            return dp[i][pIdx];
        }
        int skip = solve(nums, i + 1, p);
        int take = 0;
        if (p == -1 || nums[i] > nums[p]) {
            take = 1 + solve(nums, i + 1, i);
        }
        return dp[i][pIdx] = Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums , 0 , -1);
    }
}
