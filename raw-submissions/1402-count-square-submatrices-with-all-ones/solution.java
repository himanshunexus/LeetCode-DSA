class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (matrix[i][j] == 1) {
                    if(i == 0|| j == 0){
                        res[i][j] =1;
                    }else{
                        res[i][j] = 1 + Math.min(res[i-1][j],Math.min(res[i][j-1], res[i-1][j-1]));
                    }
                count+=res[i][j];
                }
            }
        }
        return count;
    }
}
