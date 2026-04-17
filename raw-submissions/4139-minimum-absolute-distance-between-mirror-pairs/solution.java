class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            int current = nums[j];
            if (targetMap.containsKey(current)) {
                minDistance = Math.min(minDistance, j - targetMap.get(current));
            }
            targetMap.put(reverse(current), j);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
}
