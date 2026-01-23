class Solution {
    private int size(int[] nums){
        // int x=0;
        int count=0;
        // while(nums[i]!=0){
        //     int digit = nums[i];
        //     // x = digit%10;
        //     x/=10;
        //     count++;
        // }
        for(int i:nums)
        {
            while(i>0)
            {
                count++;
                i/=10;
            }
        }
        return count;
    }
    public int[] separateDigits(int[] nums) {
        int n = size(nums);
       int[] ans = new int[n];
       for(int i = nums.length-1; i>=0; i--){
            int x = nums[i];
            while(x>0){
                ans[n-1] = x % 10;
                n--;
                x/=10;
            }
       }
        return ans;
    }
}
