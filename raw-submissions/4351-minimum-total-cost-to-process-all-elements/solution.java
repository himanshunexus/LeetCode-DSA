class Solution {
    public int minimumCost(int[] nums, int k) {
        long mod = 1000000007 , sum = 0 , count = 1, rem = k;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > rem){
                long ops = (nums[i] - rem + k - 1) / k;
                long cost = ((ops % mod) * (count % mod)) % mod + (ops * ( ops - 1) / 2) % mod;
                sum = (sum + cost) % mod;
                count += ops;
                rem += ops * k;
            }
            rem -= nums[i];
        }
        return (int) sum;
    }
}
