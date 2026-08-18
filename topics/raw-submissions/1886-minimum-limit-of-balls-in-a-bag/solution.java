class Solution {
    public boolean isPossible(int[] nums , int mid , int k){
        long count = 0;
        for(int i  : nums){
            count += (i - 1)/ mid;
        }
        return count <= k;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int left = 1 , right = 0;
        for(int i : nums){
            right = Math.max(right , i);
        }
        int ans = right;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(nums , mid , maxOperations)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
