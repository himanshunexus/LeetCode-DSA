class Solution {
    private boolean solve(int max, int total, int used, Boolean[] memo) {
        if (total <= 0) return false;
        if (memo[used] != null) return memo[used];

        for (int i = 1; i <= max; i++) {
            int bit = 1 << i;
            if ((used & bit) == 0) {
                if (i >= total || !solve(max, total - i, used | bit, memo)) {
                    return memo[used] = true;
                }
            }
        }
        return memo[used] = false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;

        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;

        Boolean[] memo = new Boolean[1 << (maxChoosableInteger + 1)];
        return solve(maxChoosableInteger, desiredTotal, 0, memo);
    }
}
