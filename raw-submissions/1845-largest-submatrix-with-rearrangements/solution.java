class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        int maxArea = 0;
        int[] temp = new int[n]; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[j] = matrix[i][j];
            }
            Arrays.sort(temp); 
            for (int j = n - 1; j >= 0; j--) {
                int height = temp[j];
                int width = n - j;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        return maxArea;
    }
}
