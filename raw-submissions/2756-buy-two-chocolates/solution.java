class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int cost1 = prices[0];
        int cost2 = prices[1];
        int res = cost1 + cost2;
        int ans = 0;
        if(res <= money){
            ans = money - res;
        }else{
            ans = money;
        }
        return ans;
    }
}
