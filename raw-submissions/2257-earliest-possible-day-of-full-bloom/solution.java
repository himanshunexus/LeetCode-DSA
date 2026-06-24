class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] res = new int[n][2];
        for(int i = 0; i < n; i++){
            res[i][0] = plantTime[i];
            res[i][1] = growTime[i];
        }

        Arrays.sort(res , (x , y) -> y[1] - x[1]);

        int plantDays = 0 , maxBloomDays = 0;
        for(int i = 0; i < n; i++){
            plantDays += res[i][0];
            maxBloomDays = Math.max(plantDays + res[i][1], maxBloomDays);
        }
        return maxBloomDays;
    }
}
