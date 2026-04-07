class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
}
