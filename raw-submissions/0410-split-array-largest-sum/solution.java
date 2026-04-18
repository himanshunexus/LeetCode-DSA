class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;         
        }

        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                result = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return result;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int subarraysUsed = 1;

        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                subarraysUsed++;
                currentSum = num;
                if (subarraysUsed > k) return false;
            }
        }
        return true;
    }
}
