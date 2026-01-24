class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
       int maxSum=0;
       int n = nums.length-1;
       int i=0,j=n;
       while(i<j){
        int sum = nums[i]+nums[j];
        maxSum = Math.max(maxSum,sum);
        i++;
        j--;
       } 
       return maxSum;
    }
}
