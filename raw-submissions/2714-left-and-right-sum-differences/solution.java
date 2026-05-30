class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0 , rightSum = 0 , leftSum = 0;
        for(int i : nums){
            totalSum += i;
        }
        rightSum = totalSum;
        for(int i = 0; i < n; i++){
            int org = nums[i];
            rightSum -= org;
            nums[i] = Math.abs(rightSum - leftSum);
            leftSum += org;
        }
        return nums;
    }
}
