class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        
        prefixSum[0] = (nums[0] % 2 != 0) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + ((nums[i] % 2 != 0) ? 1 : 0);
        }
        
        int count = 0;
        int[] freq = new int[n + 1];
        freq[0] = 1;
        
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] >= k) {
                count += freq[prefixSum[i] - k];
            }
            freq[prefixSum[i]]++;
        }
        return count;
    }
}
