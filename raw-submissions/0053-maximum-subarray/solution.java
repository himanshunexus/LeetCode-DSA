class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int currSum=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<len;i++){
         
            currSum = Math.max(nums[i] , currSum + nums[i]);
            maxSum=Math.max(currSum,maxSum);
            
        }
        return maxSum;
    }
}
