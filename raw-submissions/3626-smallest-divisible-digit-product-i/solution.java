class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int newN = n;
            int curr = 1;
            while (newN > 0) {
                int digit = newN % 10;
                curr *= digit;
                newN /= 10;
            }
            if (curr % t == 0) {
                return n;
            }
            n++;
        }
    }
}
