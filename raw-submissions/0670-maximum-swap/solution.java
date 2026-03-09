class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            int maxIdx = i;
            for (int j = n - 1; j > i; j--) {
                if (digits[j] > digits[maxIdx]) {
                    maxIdx = j;
                }
            }
            int bestIdx = i;
            for (int j = n - 1; j > i; j--) {
                if (digits[j] > digits[bestIdx]) {
                    if (bestIdx == i || digits[j] > digits[bestIdx]) {
                        bestIdx = j;
                    }
                }
            }
            if (bestIdx != i) {
                char temp = digits[i];
                digits[i] = digits[bestIdx];
                digits[bestIdx] = temp;
                return Integer.parseInt(new String(digits));
            }
        }
        return num;
    }
}
