class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n == 1) return s;
        long maxIdx = (n % 2 == 0) ? (n - 1) : (n - 2);
        long numUps = (maxIdx + 1) / 2;
        long numDown = maxIdx / 2;
        return s + (numUps * m) - numDown;
    }
}
