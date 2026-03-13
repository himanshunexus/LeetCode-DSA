class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1;
        long maxW = 0;
        for (int w : workerTimes) {
            maxW = Math.max(maxW, w);
        }
        long high = maxW * (long)mountainHeight * (mountainHeight + 1) / 2;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canReduce(long maxTime, int targetHeight, int[] workerTimes) {
        long totalHeight = 0;
        for (int w : workerTimes) {
            long val = (2 * maxTime) / w;
            long x = (long)((-1 + Math.sqrt(1 + 4 * val)) / 2);
            totalHeight += x;
            if (totalHeight >= targetHeight) {
                return true;
            }
        }
        return totalHeight >= targetHeight;
    }
}
