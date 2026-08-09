class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        double ans = 0.0;
        int n = prices.length , m = discounts.length;
        int k = Math.min(n , m);
        for(int i = 0; i < k; i++){
            int currD = discounts[m - 1 - i];
            int currP = prices[n - 1 - i];
            ans += currP * (100.0 - currD) / 100.0;
        }
        for(int i = 0; i < n - k; i++){
            ans += prices[i];
        }
        return ans;
    }
}
