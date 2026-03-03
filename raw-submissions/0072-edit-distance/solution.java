class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0 || m == 0) return n + m;
        int[][] res = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            res[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            res[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] = 1 + Math.min(
                            res[i - 1][j],  
                            Math.min(
                                    res[i][j - 1], 
                                    res[i - 1][j - 1] 
                                ));
                }
            }
        }

        return res[n][m];
    }
}
