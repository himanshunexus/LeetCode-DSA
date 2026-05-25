class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        int count = 0;
        int[] prefixSum = new int[n + 1];
        prefixSum[1] = 1;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                int left = Math.max(0, i - maxJump);
                int right = i - minJump;
                
                if (right >= left) {
                    if (prefixSum[right + 1] - prefixSum[left] > 0) {
                        dp[i] = true;
                    }
                }
            }
            prefixSum[i + 1] = prefixSum[i] + (dp[i] ? 1 : 0);
        }
        
        return dp[n - 1];
    }
}
