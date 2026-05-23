class Solution {
    public int minimumSwaps(int[] nums) {
        int right = nums.length - 1;
        int swaps = 0;
        int left= 0;
        while(left < right){
            while(left < right && nums[left] != 0){
                left++;
            }
            while(left < right && nums[right] == 0){
                right--;
            }
            if(left < right){
                swaps++;
                left++;
                right--;
            }
        }
        return swaps;
    }
}
