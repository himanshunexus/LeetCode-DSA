class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int ans = 1 << 30;

        for (int i = 0; i < ls.length; i++)
            for (int j = 0; j < ws.length; j++) {
                ans = Math.min(ans, Math.max(ls[i] + ld[i], ws[j]) + wd[j]);
                ans = Math.min(ans, Math.max(ws[j] + wd[j], ls[i]) + ld[i]);
            }

        return ans;
    }
}
