class Solution {
    public boolean isPossible(int[] nums, int mid, int k) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= mid) {
            count++;
            i++; 
        }
    }
    return count >= k;
}

    public int minCapability(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for(int i : nums){
            left = Math.min(left , i);
            right = Math.max(right , i);
        }

        int ans = right;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(nums, mid , k)){
                ans = Math.min(ans , mid);
                right = mid - 1;
            }
            else{
                left = mid + 1; 
            }
        }
        return ans;
    }
}
