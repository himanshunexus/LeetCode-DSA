class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length , ans = 0;
        for(int i = 0; i < n; i++){
            if(coins - costs[i] >= 0){
                ans++;
                coins -= costs[i];
            } 
        }
        return ans;
    }
}
