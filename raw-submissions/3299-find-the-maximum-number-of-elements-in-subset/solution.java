class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int maxLen = count.getOrDefault(1, 0);
        if (maxLen % 2 == 0 && maxLen > 0) maxLen--;
        if (maxLen == 0) maxLen = 1;

        for (int num : count.keySet()) {
            if (num == 1) continue;
            
            int currentLen = 0;
            long x = num;
            
            while (count.getOrDefault((int)x, 0) >= 2) {
                currentLen += 2;
                x *= x;
                if (x > 1000000000) break;
            }
            
            if (count.containsKey((int)x)) {
                currentLen += 1;
            } else {
                currentLen -= 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }
}

