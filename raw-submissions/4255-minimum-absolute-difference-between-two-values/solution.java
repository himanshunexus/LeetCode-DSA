class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int last1 = -1 , last2 = -1;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                last1 = i;
                if(last2 != -1){
                    ans = Math.min(ans,Math.abs(i - last2));
                }
            }
            else if(nums[i] == 2){
                last2 = i;
                if(last1 != -1){
                    ans = Math.min(ans,Math.abs( i - last1));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
