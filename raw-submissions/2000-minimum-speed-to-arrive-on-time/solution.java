class Solution {
    public boolean possible(int[] dist, int mid, double hour) {
        double time = 0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            time += Math.ceil((double) dist[i] / mid);
        }
        time += (double) dist[n - 1] / mid;
        return time <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) return -1;
        int l = 1;
        int r = 10000000;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (possible(dist, mid, hour)) {
                ans = mid;
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return ans;
    }
}
