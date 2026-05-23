class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int x = 0; x < k; x++){
            for(int y = 0; y < k; y++){
                if(x == y) continue;
                int op = 0;
                for(int i = 0; i < n; i++){
                    int target = (i % 2 == 0) ? x : y;
                    int rem = nums[i] % k;
                    int diff = Math.abs(rem - target);
                    op += Math.min(diff , k - diff);
                }
                ans = Math.min(ans  , op);
            }
        }
        return ans;
    }
}
