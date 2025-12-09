class Solution {
    public int pivotIndex(int[] nums) {
        int len=nums.length;
        // int leftsum=0;
       
        // int totalsum=0;
        // for(int i=0;i<len;i++){
        //     totalsum+=nums[i];
        // }
        // for(int i=0;i<len;i++){
        //     int rightsum=totalsum-leftsum-nums[i];
        //     if(rightsum==leftsum){
        //         return i;
        //     }
        //     leftsum+=nums[i];
        // }

        // return -1;
         
        int[] postfix = new int[len];
        postfix[len-1]=nums[len-1];
        for(int i=len-2;i>=0;i--){
            postfix[i]=postfix[i+1]+nums[i];
        }
        
        int[] prefix = new int[len];
        prefix[0]=nums[0];
        for(int i=1;i<len;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=0;i<len;i++){
            if(postfix[i]==prefix[i]){
                return i;
            }
        }
        return -1;
    }
}
