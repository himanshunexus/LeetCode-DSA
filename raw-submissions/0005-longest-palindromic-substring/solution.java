class Solution {
    public String longestPalindrome(String s) {
    int[] res = {0, 0};
    for (int i = 0; i < s.length(); i++) {
        expand(s, i, i, res);     // Odd
        expand(s, i, i + 1, res); // Even
    }
    return s.substring(res[0], res[1]);
}

private void expand(String s, int L, int R, int[] res) {
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        if (R - L + 1 > res[1] - res[0]) {
            res[0] = L;
            res[1] = R + 1;
        }
        L--; R++;
    }
}
}
