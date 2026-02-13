class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            int distinct = 0;
            int maxCount = 0;
            
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                if (count[idx] == 0) distinct++;
                count[idx]++;
                maxCount = Math.max(maxCount, count[idx]);
                int len = j - i + 1;
                if (n - i <= maxLen) break;
                if (distinct * maxCount == len) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }
}
