class Solution {
    private long countCoin(int idx, int[] coins, int amount,long[][] res){
        if(idx == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(res[idx][amount] != -1) return res[idx][amount];
        long skip = countCoin(idx+1, coins,amount,res);
        if(amount -coins[idx] < 0) return res[idx][amount] = skip;
        long pick = 1 + countCoin(idx,coins,amount-coins[idx],res);
        return  res[idx][amount] = Math.min(skip,pick);

    }
    public int coinChange(int[] coins, int amount) {
        long[][] res = new long[coins.length][amount + 1];
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                res[i][j] = -1;
            }
        }
        int ans = (int)countCoin(0,coins,amount,res);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
