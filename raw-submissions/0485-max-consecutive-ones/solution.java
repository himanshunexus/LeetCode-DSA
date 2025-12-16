class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==1){
                count++;
            }
            else{
                maxCount=Math.max(maxCount,count);
                count=0;
            }
            // maxCount=Math.max(maxCount,count);
        }
        maxCount=Math.max(maxCount,count);
        return maxCount;
    }
    
}
