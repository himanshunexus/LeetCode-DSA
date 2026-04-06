class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        int maxDistSq = 0;
        for (int cmd : commands) {
            if (cmd == -1) { 
                di = (di + 1) % 4;
            } else if (cmd == -2) {
                di = (di + 3) % 4;
            } else { 
                for (int i = 0; i < cmd; i++) {
                    int nextX = x + dx[di];
                    int nextY = y + dy[di];
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistSq = Math.max(maxDistSq, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return maxDistSq;
    }
}
