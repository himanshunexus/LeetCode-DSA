class Solution {
    public int maxAscendingSum(int[] nums) {
        int len = nums.length;
        int sum=nums[0];
        int maxSum = nums[0];
        for(int i=1;i<len;i++){
            if(nums[i-1] < nums[i]){
                sum+=nums[i];
            }
            else{
                sum = nums[i];
            }
            maxSum = Math.max(sum,maxSum);
        }
        
        return maxSum;
    }
}
