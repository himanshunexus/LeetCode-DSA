class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i]; 
        }
        
        long NEG = Long.MIN_VALUE / 2;
        long[][] dp = new long[m + 1][n + 1];

        for(int k = 0; k <= m; k++){
            for(int i = 0; i <= n; i++){
                dp[k][i] = NEG;
            }
        }
        
        for(int i = 0; i <= n; i++){
            dp[0][i] = 0;
        }

        long ans = NEG;
        int[] dq = new int[n + 1];

        for(int take = 1; take <= m; take++){
            int head = 0 , tail = 0;
            for(int i = 1; i <= n; i++){
                if(dp[take][i - 1] > NEG){
                    dp[take][i] = dp[take][i - 1];
                }

                int addJ = i - l;
                if(addJ >= 0 && dp[take - 1][addJ] > NEG){
                    long val = dp[take - 1][addJ] - prefix[addJ];
                    while(tail > head && dp[take - 1][dq[tail - 1]] - prefix[dq[tail - 1]] <= val){
                        tail--;
                    }
                    dq[tail++] = addJ;
                }
                while(tail > head && dq[head] < i - r)
                    head++;

                if(tail > head){
                    int j  = dq[head];
                    if(dp[take - 1][j] > NEG){
                        long candidate = dp[take - 1][j] + prefix[i] - prefix[j];
                        if(candidate > dp[take][i]){
                            dp[take][i] = candidate;
                        }
                    }
                }
                if(dp[take][i] > NEG && dp[take][i] > ans){
                    ans = dp[take][i];
                }
            }
        }
        return ans;
    }
}
