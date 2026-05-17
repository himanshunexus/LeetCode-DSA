class Solution {
    public int smallestUniqueSubarray(int[] nums) {
       int n = nums.length;
        int lo = 1 , hi = n , ans = n;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(hasUnique(nums,mid)){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    private boolean hasUnique(int[] nums , int L){
        long MOD1 = 1_000_000_007L , BASE1 = 131L;
        long MOD2 = 998_244_353L , BASE2 = 137L;
        long hash1 = 0, hash2 = 0;
        long pow1 = 1 , pow2 = 1;

        for(int i = 0; i < L - 1; i++){
            pow1 = pow1 * BASE1 % MOD1;
            pow2 = pow2 * BASE2 % MOD2;
        }
        Map<Long,Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hash1 = (hash1 * BASE1 + nums[i]) % MOD1;
            hash2 = (hash2 * BASE2 + nums[i]) % MOD2;
            if(i >= L){
                hash1 = (hash1 - nums[i - L] * pow1 % MOD1 * BASE1 % MOD1 + MOD1 * 2) % MOD1;
                hash2 = (hash2 - nums[i - L] * pow2 % MOD2 * BASE2 % MOD2 + MOD2 * 2) % MOD2;
            }
            if(i >= L - 1){
                long combined = hash1 * MOD2 + hash2;
                seen.merge(combined , 1 , Integer::sum);
            }
        }
        for(int v : seen.values()){
            if(v == 1)
                return true;
        }
        return false;
    }
}
