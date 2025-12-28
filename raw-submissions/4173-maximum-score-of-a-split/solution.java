class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;

        // suffix minimum array
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        long prefixSum = 0;
        long maxScore = Long.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i];
            long score = prefixSum - suffixMin[i + 1];
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;   // ✅ NO CAST
    }
}

