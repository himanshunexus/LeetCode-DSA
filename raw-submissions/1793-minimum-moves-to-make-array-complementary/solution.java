class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            diff[2] += 2;
            diff[Math.min(a, b) + 1] -= 1;
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
            diff[Math.max(a, b) + limit + 1] += 1;
        }
        int ans = n, cur = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            cur += diff[i];
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
