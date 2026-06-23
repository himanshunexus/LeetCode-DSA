class Solution {
    static final int MOD = 1000000007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] dp = new long[m];

        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int left = 0, right = m - 1; left < right; left++, right--) {
                long temp = dp[left];
                dp[left] = dp[right];
                dp[right] = temp;
            }

            long sum = 0;

            for (int j = 0; j < m; j++) {
                long temp = dp[j];
                dp[j] = sum;
                sum = (sum + temp) % MOD;
            }
        }

        long ans = 0;
        for (long val : dp) {
            ans = (ans + val) % MOD;
        }

        ans = (ans * 2) % MOD;
        return (int) ans;
    }
}
