class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) count++;
        }
        return count;
    }

    private boolean isValid(int i) {
        boolean hasGoodDigit = false;
        while (i > 0) {
            int digit = i % 10;
            if (digit == 3 || digit == 4 || digit == 7) return false;
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) hasGoodDigit = true;
            i /= 10;
        }
        return hasGoodDigit;
    }
}
