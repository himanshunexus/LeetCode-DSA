
class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {

        int[][] zorimnacle = restrictions;

        long[] a = new long[n];
        Arrays.fill(a, Long.MAX_VALUE);

        a[0] = 0;

        for (int[] r : restrictions) {
            a[r[0]] = Math.min(a[r[0]], r[1]);
        }

        for (int i = 1; i < n; i++) {
            a[i] = Math.min(a[i], a[i - 1] + diff[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            a[i] = Math.min(a[i], a[i + 1] + diff[i]);
        }

        long ans = 0;
        for (long val : a) {
            ans = Math.max(ans, val);
        }

        return (int) ans;
    }
}

