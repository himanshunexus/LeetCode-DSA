class Solution {
    public long maxTotal(int[] nums, String s) {
        int n = nums.length;
        long NEG = Long.MIN_VALUE / 2;
        long dp0 = 0 , dp1 = NEG;

        for(int i = 0; i < n; i++){
            long ndp0 , ndp1;
            if(s.charAt(i) == '0'){
                ndp0 = Math.max(dp0 , dp1);
                ndp1 = NEG;
            }
            else{
                long best = Math.max(dp0,dp1);
                ndp1 = (best == NEG) ? NEG : best + nums[i];
                ndp0 = NEG;
                if(i > 0){
                    if(dp0 != NEG) 
                        ndp0 = Math.max(ndp0 , dp0 + nums[i - 1]);
                    if(dp1 != NEG)
                        ndp0 = Math.max(ndp0 , dp1);
                }
            }
            dp0 = ndp0;
            dp1 = ndp1;
        }
        long ans = 0;
        if(dp0 != NEG) 
            ans = Math.max(ans , dp0);
        if(dp1 != NEG)
            ans = Math.max(ans , dp1);
        return ans;
    }
}
