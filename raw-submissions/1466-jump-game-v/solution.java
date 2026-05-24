class Solution {
    private int[] memo;
    private int n;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        memo = new int[n];
        int maxJumps = 0;

        for (int i = 0; i < n; i++) {
            maxJumps = Math.max(maxJumps, dfs(arr, d, i));
        }

        return maxJumps;
    }

    private int dfs(int[] arr, int d, int i) {
        if (memo[i] != 0) {
            return memo[i];
        }

        int res = 1;

        for (int j = i + 1; j <= i + d && j < n && arr[j] < arr[i]; j++) {
            res = Math.max(res, 1 + dfs(arr, d, j));
        }

        for (int j = i - 1; j >= i - d && j >= 0 && arr[j] < arr[i]; j--) {
            res = Math.max(res, 1 + dfs(arr, d, j));
        }

        return memo[i] = res;
    }
}
