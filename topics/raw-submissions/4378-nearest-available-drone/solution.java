class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int tx = target[0];
        int ty = target[1];
        int min = Integer.MAX_VALUE;
        int idx = -1;

        for(int i = 0; i < drones.length; i++){
            int x = drones[i][0];
            int y = drones[i][1];
            int r = drones[i][2];
            int dist = Math.abs(x - tx) + Math.abs(y - ty);
            if(dist <= r && dist < min){
                min = dist;
                idx = i;
            }
        }
        return idx;
    }
}
