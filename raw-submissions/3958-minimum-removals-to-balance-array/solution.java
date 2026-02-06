class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int ans = 0;
        if(len == 1) return 0;
        int maxLen = 0;
        for(int i = 0; i < len; i++){
            while(nums[i] >(long) k * nums[left]){
                left ++;
            }
            maxLen = Math.max(maxLen,i - left +1);
        }
        return len - maxLen;
    }
}
