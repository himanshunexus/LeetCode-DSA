class Solution {
    public int amt(int[] nums , int[] dp , int i){
        if (i < 0) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i] = Math.max(nums[i] + amt(nums, dp, i - 2), amt(nums, dp, i - 1));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return amt(nums, dp, n - 1);
    }
}
