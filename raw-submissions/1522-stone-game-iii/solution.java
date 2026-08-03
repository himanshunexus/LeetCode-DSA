class Solution {
    Integer[] memo;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new Integer[n];
        int result = solve(stoneValue, 0);
        if (result > 0) return "Alice";
        if (result < 0) return "Bob";
        return "Tie";
    }

    private int solve(int[] stoneValue, int i) {
        if (i >= stoneValue.length) return 0;
        if (memo[i] != null) return memo[i];

        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {
            sum += stoneValue[i + k];
            res = Math.max(res, sum - solve(stoneValue, i + k + 1));
        }
        return memo[i] = res;
    }
}
