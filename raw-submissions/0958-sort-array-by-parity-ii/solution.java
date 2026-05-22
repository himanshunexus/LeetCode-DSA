class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                ans[left] = nums[i];
                left += 2;
            } else {
                ans[right] = nums[i];
                right += 2;
            }
        }
        return ans;
    }
}
