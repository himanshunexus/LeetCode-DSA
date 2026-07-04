class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int maxPrefix = Integer.MIN_VALUE;
        for(int i = k; i < n; i++){
            maxPrefix = Math.max(maxPrefix , nums[i - k]);
            maxSum = Math.max(maxSum , maxPrefix + nums[i]);
        }
        return maxSum;
    }
}
