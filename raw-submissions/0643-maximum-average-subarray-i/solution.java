class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg=0,avg=0,sum=0,maxSum=0;
        int n=nums.length;
        for(int i=0;i<k;i++){
            sum+=nums[i];
            // avg=sum/k;
        }
        // maxAvg=avg;
        maxSum=sum;
        for(int i=1;i<=n-k;i++){
            sum=sum-nums[i-1]+nums[i+k-1];
            // avg=sum/k;
            // maxAvg=Math.max(avg,maxAvg);
            maxSum=Math.max(sum,maxSum);
        }
        // return maxAvg;
        return maxSum/k;
    }
}
