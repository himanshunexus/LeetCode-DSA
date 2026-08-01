class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n + 1];
        for(int[] b : boosts){
            int l = b[0];
            int r = b[1];
            int v = b[2];
            diff[l] += v;
            diff[r + 1] -= v;
        }
        
        long[] bonus = new long[n];
        long curr = 0;
        for(int i = 0; i < n; i++){
            curr += diff[i];
            bonus[i] = curr;
        }
        
        long rqd = 0;
        for(int i = n - 1; i >= 0; i--){
            long defeat = monsters[i] - bonus[i];
            if(defeat < 0) defeat = 0;
            long nextRqd = 0;
            if(rqd > 0){
                nextRqd = monsters[i] + rqd;
            }
            rqd = Math.max(defeat , nextRqd);
        }
        return rqd;
    }
}
