class Solution {
    public int countSubstrings(String s) {
        int n = s.length() , count = 0;
        int[][] res = new int[n][n];
        
        for(int k = 0; k < n; k++){
            int i = 0 , j = k;
            while(j < n){
                if( i == j){
                    res[i][j] = 1; count++;
                }
                else if( j == i + 1){
                    if(s.charAt(i) == s.charAt(j)){
                        res[i][j] = 1;
                        count++;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(res[i+1][j-1] == 1){
                            res[i][j] = 1;
                            count++;
                        }
                    }
                }
                i++; j++;
            }
        }
        return count;
    }
}
