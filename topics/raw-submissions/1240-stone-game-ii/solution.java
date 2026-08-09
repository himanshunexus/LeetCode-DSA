class Solution {
    private int[][][] memo;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        memo = new int[2][n][n + 1];
        for (int[][] page : memo) {
            for (int[] row : page) {
                Arrays.fill(row, -1);
            }
        }
        return solve(piles, true, 0, 1);
    }

    private int solve(int[] piles, boolean isAlice, int i, int m) {
        if (i >= n) {
            return 0;
        }

        int turn = isAlice ? 1 : 0;
        if (memo[turn][i][m] != -1) {
            return memo[turn][i][m];
        }

        int result = isAlice ? 0 : Integer.MAX_VALUE;
        int stonesTaken = 0;

        for (int x = 1; x <= Math.min(2 * m, n - i); x++) {
            stonesTaken += piles[i + x - 1];
            int nextM = Math.max(m, x);

            if (isAlice) {
                result = Math.max(result, stonesTaken + solve(piles, false, i + x, nextM));
            } else {
                result = Math.min(result, solve(piles, true, i + x, nextM));
            }
        }
        return memo[turn][i][m] = result;
    }
}
