class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int T = 1;
        while (T <= 1500) {
            T <<= 1;
        }
        T <<= 1;  

        boolean[] pair = new boolean[T];
        boolean[] triplet = new boolean[T];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }
        for (int x = 0; x < T; x++) {
            if (pair[x]) {
                for (int num : nums) {
                    triplet[x ^ num] = true;
                }
            }
        }
        int count = 0;
        for (boolean val : triplet) {
            if (val) {
                count++;
            }
        }
        return count;
    }
}
