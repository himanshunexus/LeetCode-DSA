class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr_sum = Integer.MIN_VALUE;
        for(int i : nums){
            if(curr_sum<=0) curr_sum = i;
            else {
                curr_sum += i;
            } 
            max = max<curr_sum ? curr_sum : max;
        }
        return max;
    }
}
