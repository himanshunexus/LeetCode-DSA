class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int k = 0; k < 4; k++) {
            if (equal(mat, target)) return true;
            rotate(mat);
        }
        return false;
    }
    private void rotate(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        for (int row = 0; row < n; row++) {
            int i = 0, j = n - 1;
            while (i < j) {
                int t = m[row][i];
                m[row][i] = m[row][j];
                m[row][j] = t;
                i++;
                j--;
            }
        }
    }
    private boolean equal(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (a[i][j] != b[i][j]) return false;
        return true;
    }
}



