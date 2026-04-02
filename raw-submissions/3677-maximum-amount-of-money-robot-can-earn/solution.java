class Solution {
    private Integer[][][] memo;

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        memo = new Integer[m][n][3];
        return solve(coins, 0, 0, 2);
    }

    private int solve(int[][] coins, int i, int j, int neu) {
        int m = coins.length;
        int n = coins[0].length;

        if (i >= m || j >= n) {
            return -1000000000;
        }

        if (memo[i][j][neu] != null) {
            return memo[i][j][neu];
        }

        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && neu > 0) {
                return 0;
            }
            return coins[i][j];
        }

        long resDown = solve(coins, i + 1, j, neu);
        long resRight = solve(coins, i, j + 1, neu);
        int take = coins[i][j] + (int) Math.max(resDown, resRight);

        int skip = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && neu > 0) {
            long skipDown = solve(coins, i + 1, j, neu - 1);
            long skipRight = solve(coins, i, j + 1, neu - 1);
            skip = (int) Math.max(skipDown, skipRight);
        }

        return memo[i][j][neu] = Math.max(take, skip);
    }
}
