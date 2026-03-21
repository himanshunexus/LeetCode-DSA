class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length , m = grid[0].length;
        int startRow = x , startCol = y;
        int endRow = x + k - 1 , endCol = y + k -1;
        while(startRow < endRow){
            for(int i = startCol; i <= endCol; i++){
                int temp = grid[startRow][i];
                grid[startRow][i] = grid[endRow][i];
                grid[endRow][i] = temp;
            }
            startRow++;
            endRow--;
        }
        return grid;
    }
}
