class Solution {
    public int isPossible(int[] nums, int mid){
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] + mid - 1) / mid;
        }
        return (int)sum;
    }
    public int smallestDivisor(int[] nums, int t) {
        int left = 1;
        int right = 0;
        for(int i : nums){
            right = Math.max(right , i);
        }
        int ans = right;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(nums , mid ) <= t){
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
