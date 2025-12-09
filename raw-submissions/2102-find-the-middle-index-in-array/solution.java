class Solution {
    public int findMiddleIndex(int[] nums) {
        int len= nums.length;
        int[] prefix = new int[len];
        prefix[0]=nums[0];
        for(int i=1;i<len;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int[] postfix = new int[len];
        postfix[len-1]=nums[len-1];
        for(int i=len-2;i>=0;i--){
            postfix[i]=postfix[i+1]+nums[i];
        }
        for (int i = 0; i < len; i++) {
            int left = prefix[i] - nums[i];
            int right = postfix[i] - nums[i];

            if (left == right) {
                return i;
            }
        }

        return -1;
      
    }
}
