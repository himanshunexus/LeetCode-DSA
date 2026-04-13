class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                int currDis = Math.abs(i - start);
                if(currDis < res){
                    res = currDis;
                }
                
            }
        }
        return res;
    }
}
