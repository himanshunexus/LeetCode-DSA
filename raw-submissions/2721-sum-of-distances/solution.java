class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            if (size <= 1) continue;
            long totalSum = 0;
            for (int idx : indices) {
                totalSum += idx;
            }

            long prefixSum = 0;
            for (int i = 0; i < size; i++) {
                int currentIdx = indices.get(i);
                long countLeft = i;
                long countRight = size - 1 - i;
                long suffixSum = totalSum - prefixSum - currentIdx;
                res[currentIdx] = (countLeft * currentIdx - prefixSum) + 
                (suffixSum - countRight * currentIdx);
                prefixSum += currentIdx;
            }
        }
        return res;
    }
}
