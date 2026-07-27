class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }
        int[] dr = {0,  1,  0, -1};
        int[] dc = {1,  0, -1,  0};

        int r = 0 , c = 0, dir = 0;
        ListNode curr = head;

        while (curr != null) {
            ans[r][c] = curr.val;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n || ans[nr][nc] != -1) {
                dir = (dir + 1) % 4;   
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
            curr = curr.next;
        }
        return ans;
    }
}
