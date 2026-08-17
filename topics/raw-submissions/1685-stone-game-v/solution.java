class Solution {
    public int solve(int[] stoneValue , int l , int r , int[] prefix , int[][] memo){
        if(l >= r) return 0;
        if(memo[l][r] != -1) return memo[l][r];

        int maxScore = 0;
        for(int mid = l; mid < r; mid++){
            int leftSum = prefix[mid] - (l > 0 ? prefix[l - 1] : 0);
            int rightSum = prefix[r] - prefix[mid];
            if(leftSum > rightSum){
                maxScore = Math.max(maxScore , rightSum + solve(stoneValue , mid + 1 , r , prefix , memo));
            }
            else if(rightSum > leftSum){
                maxScore = Math.max(maxScore , leftSum + solve(stoneValue , l , mid , prefix , memo));
            }
            else{
                maxScore =  Math.max(maxScore , Math.max((rightSum + solve(stoneValue , mid + 1 , r , prefix , memo)), (leftSum + solve(stoneValue , l , mid , prefix , memo))));
            }
        }
        return memo[l][r] = maxScore;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefix = new int[n];
        prefix[0] = stoneValue[0];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i -  1] + stoneValue[i];
        }

        int[][] memo = new int[501][501];
        for(int[] row : memo){
            Arrays.fill(row , -1);
        }

        return solve(stoneValue , 0 , n - 1 , prefix , memo);
    }
}
