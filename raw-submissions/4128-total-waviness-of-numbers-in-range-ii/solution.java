class Solution {
    private long[][][][] dp;
    private long[][][][] cnt;
    private String s;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long num) {
        if (num < 100) return 0;
        s = String.valueOf(num);
        int n = s.length();
        dp = new long[n][2][11][11];
        cnt = new long[n][2][11][11];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 11; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                    Arrays.fill(cnt[i][j][k], -1);
                }
            }
        }
        return dfs(0, 1, 10, 10, 0)[0];
    }

    private long[] dfs(int idx, int tight, int last, int secLast, int leading) {
        if (idx == s.length()) {
            return new long[]{0, leading};
        }
        if (dp[idx][tight][last][secLast] != -1) {
            return new long[]{dp[idx][tight][last][secLast], cnt[idx][tight][last][secLast]};
        }

        long totalWave = 0;
        long totalCount = 0;
        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            int nTight = (tight == 1 && d == limit) ? 1 : 0;
            int nLeading = (leading == 1 || d > 0) ? 1 : 0;
            
            int nLast = nLeading == 1 ? d : 10;
            int nSecLast = nLeading == 1 ? last : 10;

            long[] next = dfs(idx + 1, nTight, nLast, nSecLast, nLeading);
            
            totalWave += next[0];
            totalCount += next[1];

            if (nLeading == 1 && secLast < 10) {
                if ((last > secLast && last > d) || (last < secLast && last < d)) {
                    totalWave += next[1];
                }
            }
        }

        dp[idx][tight][last][secLast] = totalWave;
        cnt[idx][tight][last][secLast] = totalCount;
        return new long[]{totalWave, totalCount};
    }
}
