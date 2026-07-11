class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    int[] diff = new int[1001];
    int sum = 0;
    for(int i = 0; i < trips.length; i++){
        int a = trips[i][0];
        int b = trips[i][1];
        int c = trips[i][2];
        diff[b] = diff[b] + a;
        diff[c] = diff[c] - a;
    }   
    for(int i = 0; i < 1001; i++){
        sum += diff[i];
        if(sum > capacity) return false;
    }
    return true;
    }
}
