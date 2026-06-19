class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = 1, high = 0;
        for (int c : bloomDay) {
            high = Math.max(high, c);
        }

        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canBloom(bloomDay, mid, m, k)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private boolean canBloom(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int c : bloomDay) {
            if (c <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
