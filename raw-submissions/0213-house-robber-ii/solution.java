class Solution {
    public int amt(int[] nums, int[] dp, int i, int start) {
        if (i < start) return 0;
        if (dp[i] != -1) return dp[i];
        return dp[i] = Math.max(nums[i] + amt(nums, dp, i - 2, start), amt(nums, dp, i - 1, start));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = amt(nums, dp1, n - 2, 0);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = amt(nums, dp2, n - 1, 1);

        return Math.max(case1 , case2);
    }
}
