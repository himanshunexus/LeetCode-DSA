class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] temp = new int[n + 1][2];
        int idx = 0;
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            temp[idx] = intervals[i];
            idx++;
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            if (intervals[i][0] < newInterval[0]) {
                newInterval[0] = intervals[i][0];
            }
            if (intervals[i][1] > newInterval[1]) {
                newInterval[1] = intervals[i][1];
            }
            i++;
        }
        temp[idx] = newInterval;
        idx++;

        while (i < n) {
            temp[idx] = intervals[i];
            idx++;
            i++;
        } 

        int[][] res = new int[idx][2];
        for (int j = 0; j < idx; j++) {
            res[j] = temp[j];
        }

        return res;
    }
}
