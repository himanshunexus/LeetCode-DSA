class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int n = intervals.length;
        int ans = 0;
        int maxEnd = 0;
        for(int i = 0; i < n; i++){
            int first = intervals[i][0];
            int second = intervals[i][1];
            if (second > maxEnd) {
                ans++;
                maxEnd = second;
            }
        }
        return ans;
    }
}
