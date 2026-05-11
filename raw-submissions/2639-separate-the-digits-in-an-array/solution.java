class Solution {
    private int size(int[] nums){
        int count = 0;
        for(int i : nums){
            while(i > 0){
                count++;
                i /= 10;
            }
        }
        return count;
    }
    public int[] separateDigits(int[] nums) {
        int n = size(nums);
       int[] ans = new int[n];
       for(int i = nums.length - 1; i >= 0; i--){
            int x = nums[i];
            while(x > 0){
                ans[n-1] = x % 10;
                n--;
                x /= 10;
            }
       }
        return ans;
    }
}
