class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int sRow = 0, sCol = 0;
        int eRow = matrix.length - 1, eCol = matrix[0].length - 1;

        while (sRow <= eRow && sCol <= eCol) {
            for (int j = sCol; j <= eCol; j++) {
                res.add(matrix[sRow][j]);
            }
            sRow++;
            for (int i = sRow; i <= eRow; i++) {
                res.add(matrix[i][eCol]);
            }
            eCol--;
            if (sRow <= eRow) {
                for (int j = eCol; j >= sCol; j--) {
                    res.add(matrix[eRow][j]);
                }
                eRow--;
            }
            if (sCol <= eCol) {
                for (int i = eRow; i >= sRow; i--) {
                    res.add(matrix[i][sCol]);
                }
                sCol++;
            }
        }
        return res;
    }
}

