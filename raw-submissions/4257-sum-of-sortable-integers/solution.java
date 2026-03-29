class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            if (isSortable(nums, k)) {
                totalSum += k;
            }
        }
        return (int) totalSum;
    }

    private boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int maxOfPrevBlock = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += k) {
            int maxOfCurrentBlock = Integer.MIN_VALUE;
            boolean hasBreakPoint = false;
            for (int j = i; j < i + k; j++) {
                if (nums[j] < maxOfPrevBlock) {
                    return false;
                }
                if (j > i && nums[j] < nums[j - 1]) {
                    if (hasBreakPoint) return false;
                    hasBreakPoint = true;
                }
                maxOfCurrentBlock = Math.max(maxOfCurrentBlock, nums[j]);
            }
            if (hasBreakPoint) {
                if (nums[i] < nums[i + k - 1]) {
                    return false;
                }
            }
            maxOfPrevBlock = maxOfCurrentBlock;
        }
        return true;
    }
}
