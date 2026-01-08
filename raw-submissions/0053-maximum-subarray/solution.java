class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int currSum=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<len;i++){
         
            currSum = Math.max(nums[i] , currSum + nums[i]);
            maxSum=Math.max(currSum,maxSum);
            
        }

        // int sum=Integer.MIN_VALUE;
        // int maxSum=Integer.MIN_VALUE;
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=nums[j];

        //         maxSum = Math.max(sum,maxSum);
        //     }
            
        // }
        return maxSum;
    }
}
