class Solution {
    public int countPrimeSetBits(int left, int right) {
        int totalCount = 0;
        int primeMask = 665772;
        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (((1 << setBits) & primeMask) != 0) {
                totalCount++;
            }
        }
        return totalCount;
    }
}
