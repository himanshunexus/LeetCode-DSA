class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, int idx, String word) {
        if (idx == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] dir : directions) {
            if (find(board, i + dir[0], j + dir[1], idx + 1, word)) return true;
        }

        board[i][j] = temp;
        return false;
    }
}
