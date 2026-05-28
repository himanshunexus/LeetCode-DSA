class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0] , count = 0 , n = nums.length;
        for(int num : nums){
            if(count == 0) 
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        int freq = 0;
        for(int num : nums){
            if(num == candidate){
                freq++;
            }
        }
        return (freq > n / 2) ? candidate : -1;
    }
}
