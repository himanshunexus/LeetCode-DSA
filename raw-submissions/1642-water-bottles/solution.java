class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int remB = 0;
        int ans = numBottles;
        while( numBottles >= numExchange){
            int newB = numBottles / numExchange;
            remB = numBottles % numExchange;
            numBottles /= numExchange;
            ans += newB;
            numBottles += remB;

        }
        return ans;
    }
}
