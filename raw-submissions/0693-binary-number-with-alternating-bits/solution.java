class Solution {
    public boolean hasAlternatingBits(int n) {
        int shifted = n ^ (n >> 1);
        return (shifted & (shifted + 1)) == 0;
    }
}
