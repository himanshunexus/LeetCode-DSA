class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], new ArrayList<>());
            }
            indexMap.get(nums[i]).add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int queryIdx : queries) {
            int targetVal = nums[queryIdx];
            List<Integer> indices = indexMap.get(targetVal);

            if (indices.size() <= 1) {
                result.add(-1);
                continue;
            }

            int pos = findPosition(indices, queryIdx);
            int m = indices.size();
            
            int leftIdx = indices.get((pos - 1 + m) % m);
            int rightIdx = indices.get((pos + 1) % m);

            int d1 = Math.abs(queryIdx - leftIdx);
            int distLeft = Math.min(d1, n - d1);

            int d2 = Math.abs(queryIdx - rightIdx);
            int distRight = Math.min(d2, n - d2);

            result.add(Math.min(distLeft, distRight));
        }
        return result;
    }

    private int findPosition(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == target) return mid;
            if (list.get(mid) < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
