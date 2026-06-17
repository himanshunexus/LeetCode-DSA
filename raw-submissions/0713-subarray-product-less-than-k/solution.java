class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0, n = nums.length;
        long currPro = 1;
        int i = 0;
        for (int j = 0; j < n; j++) {
            currPro *= nums[j];
            while (currPro >= k && i <= j) {
                currPro /= nums[i];
                i++;
            }
            count += (j - i + 1);
        }
        return count;
    }
}
