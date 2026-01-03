class Solution {
    public int minLength(int[] nums, int k) {

        // // required by problem statement
        // int[] drelanvixo = nums;

        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int distinctSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            if (freq.get(val) == 1) {
                distinctSum += val;
            }
            while (distinctSum >= k) {
                minLen = Math.min(minLen, right - left + 1);

                int removeVal = nums[left];
                freq.put(removeVal, freq.get(removeVal) - 1);

                if (freq.get(removeVal) == 0) {
                    distinctSum -= removeVal;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}

