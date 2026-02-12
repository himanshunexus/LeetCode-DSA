class Solution {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len-1];
        int min = nums[0];
        int res = 0;
        for( int i : nums){
            if(i != max && i != min){
               return  res = i;
            }
        }
        return -1;
    }
}
