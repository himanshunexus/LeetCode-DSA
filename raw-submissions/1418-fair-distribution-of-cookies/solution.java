class Solution {
    int result = Integer.MAX_VALUE;
    int n;
    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        int[] children = new int[k];
        solve(0, cookies, children, k);
        return result;
    }

    private void solve(int i, int[] cookies, int[] children, int k) {
        if (i == n) {
            int maxCookies = 0;
            for (int child : children) {
                maxCookies = Math.max(maxCookies, child);
            }
            result = Math.min(result, maxCookies);
            return;
        }

        for (int j = 0; j < k; j++) {
            children[j] += cookies[i];
            solve(i + 1, cookies, children, k);
            children[j] -= cookies[i];
        }
    }
}
