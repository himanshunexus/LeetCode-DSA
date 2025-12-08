class Solution {
    public int[] runningSum(int[] nums) {
        int len=nums.length;
        int ans[] = new int[len];
        ans[0]=nums[0];
        for(int i=1;i<len;i++){
            ans[i]=ans[i-1]+nums[i];
        }
        return ans;

       
        // for(int i=0;i<len;i++){
        //     if(nums[i]%2==0){
        //         ans[i]=nums[i];
        //     }

        // }
        // return ans;
    }
}
