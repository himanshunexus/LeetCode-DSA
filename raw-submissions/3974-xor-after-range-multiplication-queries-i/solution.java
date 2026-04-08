class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;
        for (int[] query : queries) {
            int L = query[0];
            int R = query[1];
            int K = query[2];
            long V = query[3];
            for (int i = L; i <= R; i += K) {
                long val = nums[i];
                nums[i] = (int) ((val * V) % MOD);
            }
        }
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        return xorSum;
    }
}
