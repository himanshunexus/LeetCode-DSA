class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int dominant = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > max) {
                max = map.get(num);
                dominant = num;
            }
        }
        int left = 0;
        int maxL = 0, maxR = max;
        while (left < nums.size()) {
            if (nums.get(left) == dominant) {
                maxL++;
                maxR--;
            }
            if (maxL * 2 > (left + 1) && maxR * 2 > (nums.size() - left - 1)) {
                return left;
            }
            left++;
        }
        return -1;
    }
}
