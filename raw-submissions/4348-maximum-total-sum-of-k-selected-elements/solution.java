class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans = 0;
        int idx = nums.length - 1;
        for(int  i = 0; i < k; i++){
            long val = nums[idx--];
            long factor = Math.max(1L , (long)mul - i);
            ans += val * factor;
        }
        return ans;
    }
}
