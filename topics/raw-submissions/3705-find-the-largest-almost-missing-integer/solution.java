class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int ans = -1;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i + k <= n; i++) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            for (int x : map.keySet()) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
        }

        for (int x : freq.keySet()) {
            if (freq.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}
