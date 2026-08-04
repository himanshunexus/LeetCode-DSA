class Solution {
    public boolean bs(int[] nums, int start , int end , int target){
        int left = start , right = end;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int breakIdx = -1;

        for(int i = 0; i < n - 1; i++){
            if(nums[i] > nums[i + 1]){
                breakIdx = i + 1;
                break;
            }
        }
        if (breakIdx == -1) {
            return bs(nums, 0, n - 1, target);
        }
        return bs(nums, 0, breakIdx - 1, target) || bs(nums, breakIdx, n - 1, target);
    }
}
