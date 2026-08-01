class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] colorCount = new int[n][11];

        for (int[] p : pick) {
            int player = p[0];
            int color = p[1];
            colorCount[player][color]++;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int color = 0; color <= 10; color++) {
                if (colorCount[i][color] > i) {
                    count++;
                    break; 
                }
            }
        }
        return count;
    }
}
