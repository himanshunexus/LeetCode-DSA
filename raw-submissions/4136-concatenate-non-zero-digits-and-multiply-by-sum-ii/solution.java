class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1000000007;
        
        int[] nonZeroCount = new int[m + 1];
        long[] prefixSum = new long[m + 1];
        long[] prefixHash = new long[m + 1];
        long[] power10 = new long[m + 1];
        
        power10[0] = 1;
        for (int i = 1; i <= m; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }
        
        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            
            nonZeroCount[i + 1] = nonZeroCount[i];
            prefixSum[i + 1] = prefixSum[i];
            prefixHash[i + 1] = prefixHash[i];
            
            if (digit != 0) {
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
                prefixSum[i + 1] = prefixSum[i] + digit;
                prefixHash[i + 1] = (prefixHash[i] * 10 + digit) % MOD;
            }
        }
        
        int n = queries.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int totalNonZeroInSub = nonZeroCount[r + 1] - nonZeroCount[l];
            if (totalNonZeroInSub == 0) {
                answer[i] = 0;
            } else {
                long currentSum = prefixSum[r + 1] - prefixSum[l];
                long hashR = prefixHash[r + 1];
                long hashL = prefixHash[l];
                long multipliedHashL = (hashL * power10[totalNonZeroInSub]) % MOD;
                long x = (hashR - multipliedHashL + MOD) % MOD;
                answer[i] = (int) ((x * currentSum) % MOD);
            }
        }
        return answer;
    }
}
