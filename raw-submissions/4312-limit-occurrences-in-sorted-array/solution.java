class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        int idx = 0 , count = 1;
        res[idx++] = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]){
                count++;
            }else{
                count = 1;
            }
            if(count <= k){
                res[idx++] = nums[i];
            }
        }
        return Arrays.copyOf(res,idx);
    }
}
