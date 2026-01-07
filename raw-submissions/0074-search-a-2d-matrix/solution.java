class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left =0;
        int right =rows * cols - 1;

        int midRow=0;
        int midCol =0;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            midRow = mid/cols;
            midCol = mid%cols;
            if(matrix[midRow][midCol] == target)
                return true;
            else if(matrix[midRow][midCol] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
}
