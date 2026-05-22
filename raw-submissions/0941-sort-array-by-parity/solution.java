class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int left = 0 ,  right = n - 1;
        while(left < right){
            while(nums[left] % 2 != 0 && left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
            left++;
        }
        return nums;
    }
}
