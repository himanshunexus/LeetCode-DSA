class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
        int[][] res = new int[rows * cols][2];
        int[][] dirs = {
            {0, 1}, //'EAST'
            {1, 0}, // SOUTH
            {0, -1}, // WEST
            {-1, 0} // NORTH
            };

        int idx = 0, len = 0, d = 0;
        
        res[idx++] = new int[]{r, c};

        while (idx < rows * cols) {

            if (d % 2 == 0) len++; // Increment step size after East and West

            for (int i = 0; i < len; i++) {

                r += dirs[d][0];
                c += dirs[d][1];

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res[idx++] = new int[]{r, c};
                }
            }
            d = (d + 1) % 4;
        }
        return res;
    }
}
