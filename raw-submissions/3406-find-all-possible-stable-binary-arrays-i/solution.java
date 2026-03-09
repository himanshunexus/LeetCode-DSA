class Solution {
    private final int MOD = 1_000_000_007;
    private Integer[][][] memo;

    private int subArrCount(int zeros, int ones, int limit, int lastWasOne) {
        if (zeros == 0 && ones == 0) return 1;
        if (memo[zeros][ones][lastWasOne] != null) {
            return memo[zeros][ones][lastWasOne];
        }

        long count = 0;
        if (lastWasOne == 1) { 
            for (int i = 1; i <= Math.min(zeros, limit); i++) {
                count = (count + subArrCount(zeros - i, ones, limit, 0)) % MOD;
            }
        } else { 
            for (int i = 1; i <= Math.min(ones, limit); i++) {
                count = (count + subArrCount(zeros, ones - i, limit, 1)) % MOD;
            }
        }

        return memo[zeros][ones][lastWasOne] = (int) count;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        memo = new Integer[zero + 1][one + 1][2];
        long startWithZero = subArrCount(zero, one, limit, 1);
        memo = new Integer[zero + 1][one + 1][2];
        long startWithOne = subArrCount(zero, one, limit, 0);
        return (int) ((startWithZero + startWithOne) % MOD);
    }
}
