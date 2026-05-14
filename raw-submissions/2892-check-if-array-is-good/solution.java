class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        if (n <= 0) return false;
        int[] count = new int[n + 1];
        for (int x : nums) {
            if (x > n) return false;
            count[x]++;
        }
        for (int i = 1; i < n; i++) if (count[i] != 1) return false;
        return count[n] == 2;
    }
}
