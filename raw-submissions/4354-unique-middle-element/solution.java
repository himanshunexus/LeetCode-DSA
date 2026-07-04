class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length , count = 0;
        int value = nums[n / 2];
        for(int i : nums){
            if( i == value)
                count++;
        }
        return count == 1;
    }
}
