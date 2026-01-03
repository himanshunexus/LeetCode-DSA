class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfRoutes(String[] grid, int d) {
        String[] frovitanel = grid; 
        int n = grid.length;
        int m = grid[0].length();
        long dSq = (long) d * d;

        long[][] dp = new long[m][2];

        for (int c = 0; c < m; c++) {
            if (grid[n - 1].charAt(c) == '.') dp[c][0] = 1;
        }

        for (int r = n - 1; r >= 0; r--) {
            long[] prefV = getPrefixSums(dp, 0, m);
            for (int c = 0; c < m; c++) {
                if (grid[r].charAt(c) == '.') {
                    int left = Math.max(0, c - d);
                    int right = Math.min(m - 1, c + d);
                    long sum = (prefV[right + 1] - prefV[left] + MOD) % MOD;
                    dp[c][1] = (sum - dp[c][0] + MOD) % MOD;
                } else {
                    dp[c][1] = 0;
                }
            }
            if (r > 0) {
                long[][] nextRowDp = new long[m][2];
                int maxDc = (dSq < 1) ? -1 : (int) Math.sqrt(dSq - 1);
                
                long[] currentTotalPref = new long[m + 1];
                for (int c = 0; c < m; c++) {
                    currentTotalPref[c + 1] = (currentTotalPref[c] + dp[c][0] + dp[c][1]) % MOD;
                }

                for (int nc = 0; nc < m; nc++) {
                    if (grid[r - 1].charAt(nc) == '.' && maxDc >= 0) {
                        int left = Math.max(0, nc - maxDc);
                        int right = Math.min(m - 1, nc + maxDc);
                        nextRowDp[nc][0] = (currentTotalPref[right + 1] - currentTotalPref[left] + MOD) % MOD;
                    }
                }
                dp = nextRowDp;
            }
        }

        long ans = 0;
        for (int c = 0; c < m; c++) ans = (ans + dp[c][0] + dp[c][1]) % MOD;
        return (int) ans;
    }

    private long[] getPrefixSums(long[][] dp, int type, int m) {
        long[] pref = new long[m + 1];
        for (int i = 0; i < m; i++) {
            pref[i + 1] = (pref[i] + dp[i][type]) % MOD;
        }
        return pref;
    }
}
