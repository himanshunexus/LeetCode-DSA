class Solution {
    static int[][] res;
    private int lcs(int i,int j,StringBuilder a , StringBuilder b){
        if(i < 0 || j < 0) return 0;
        if(res[i][j] != -1) return res[i][j];
        if(a.charAt(i) == b.charAt(j))
            return res[i][j] = 1 + lcs(i-1,j-1,a,b);
        else
            return res[i][j] = Math.max(lcs(i-1,j,a,b),lcs(i,j-1,a,b));
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder a = new StringBuilder(s);
        StringBuilder b = new StringBuilder(s).reverse();
        int m = a.length() , n = b.length();
        res = new int[m][n];
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                res[i][j] = -1;
            }
        }
        return lcs(m-1,n-1,a,b);
    }
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}
