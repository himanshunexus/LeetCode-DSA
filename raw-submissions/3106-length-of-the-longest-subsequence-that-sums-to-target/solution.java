class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] res = new int[target + 1];
        Arrays.fill(res, -1);
        res[0] = 0;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (res[i - num] != -1) {
                    res[i] = Math.max(res[i], res[i - num] + 1);
                }
            }
        }
        return res[target];
    }
}
