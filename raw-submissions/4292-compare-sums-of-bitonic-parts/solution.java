class Solution {
    public int compareBitonicSums(int[] nums) {
        int peak = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[peak]){
                peak = i;
            }
        }
        long left = 0 , right = 0;
        for(int i = 0; i <= peak; i++){
            left += nums[i];
        }
        for(int i = peak; i < nums.length; i++){
            right += nums[i];
        }
        return left > right ? 0 : right > left ? 1 : -1;
    }
}
