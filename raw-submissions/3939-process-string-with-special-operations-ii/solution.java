class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') len[i + 1] = len[i] > 0 ? len[i] - 1 : 0;
            else if (c == '#') len[i + 1] = len[i] * 2;
            else if (c == '%') len[i + 1] = len[i];
            else len[i + 1] = len[i] + 1;
        }
        if (k >= len[n]) return '.';
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') continue;
            else if (c == '%') {
                if (len[i] > 0) k = len[i] - 1 - k;
            } else if (c == '#') {
                if (len[i] > 0) k %= len[i];
            } else {
                if (k == len[i]) return c;  
            }
        }
        return '.';
    }
}
