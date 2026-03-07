class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int diff1 = 0;
        int diff2 = 0; 
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 2 * n; i++) {
            char currentChar = s.charAt(i % n);
            
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';
            if (currentChar != expected1) diff1++;
            if (currentChar != expected2) diff2++;
            if (i >= n) {
                char charToRemove = s.charAt((i - n) % n);
                char oldExpected1 = ((i - n) % 2 == 0) ? '0' : '1';
                char oldExpected2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (charToRemove != oldExpected1) diff1--;
                if (charToRemove != oldExpected2) diff2--;
            }
            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }
        return ans;
    }
}
