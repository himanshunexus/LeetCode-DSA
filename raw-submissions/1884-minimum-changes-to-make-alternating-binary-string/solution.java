class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int startZero = 0; 
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { 
                if (s.charAt(i) == '1') {
                    startZero++;
                }
            } else { 
                if (s.charAt(i) == '0') {
                    startZero++; 
                }
            }
        }
        int startOne = n - startZero;
        return Math.min(startOne, startZero);
    }
}
