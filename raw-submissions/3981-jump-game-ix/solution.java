class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] preMax = new int[n];
        preMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        int[] ans = new int[n];
        ans[n - 1] = preMax[n - 1];

        int sufMin = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (preMax[i] > sufMin) {
                ans[i] = ans[i + 1];
            } else {
                ans[i] = preMax[i];
            }

            sufMin = Math.min(sufMin, nums[i]);
        }

        return ans;
    }
}
