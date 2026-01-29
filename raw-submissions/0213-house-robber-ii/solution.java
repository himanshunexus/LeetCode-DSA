class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int[] res = new int[n];
        res[0] = nums[0];
        res[1] = nums[1];
        
        res[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n-1; i++){
            res[i] = Math.max(nums[i] + res[i-2], res[i-1]);
        }
        int case1 = res[n-2];
        
        res[1] = nums[1];
        res[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++){
            res[i] = Math.max(nums[i] + res[i-2], res[i-1]);
        }
        int case2 = res[n-1];
        
        return Math.max(case1, case2);
    }
}
