class Solution {
    public long minCost(int[] nums, int[] cost) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int x : nums) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }
        long ans = getCost(nums, cost, left);
        while (left < right) {
            int mid = left + (right - left) / 2;
            long costMid = getCost(nums, cost, mid);
            long costNext = getCost(nums, cost, mid + 1);
            ans = Math.min(costMid, costNext);
            if (costMid > costNext) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return ans;
    }
    private long getCost(int[] nums, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += (long) Math.abs(nums[i] - target) * cost[i];
        }
        return total;
    }
}
