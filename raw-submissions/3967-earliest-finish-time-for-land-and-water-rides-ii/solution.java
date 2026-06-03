class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int numLandRides = landDuration.length;
        int numWaterRides = waterDuration.length;
        int minLandEndTime = Integer.MAX_VALUE;
        int minWaterEndTime = Integer.MAX_VALUE;
        
        for (int i = 0; i < numLandRides; i++) {
            minLandEndTime = Math.min(minLandEndTime, landStartTime[i] + landDuration[i]);
        }
        for (int i = 0; i < numWaterRides; i++) {
            minWaterEndTime = Math.min(minWaterEndTime, waterStartTime[i] + waterDuration[i]);
        }
        int minTotalFinishTime = Integer.MAX_VALUE;
        for (int i = 0; i < numLandRides; i++) {
            int landFinishTime = Math.max(minWaterEndTime, landStartTime[i]) + landDuration[i];
            minTotalFinishTime = Math.min(minTotalFinishTime, landFinishTime);
        }
        for (int i = 0; i < numWaterRides; i++) {
            int waterFinishTime = Math.max(minLandEndTime, waterStartTime[i]) + waterDuration[i];
            minTotalFinishTime = Math.min(minTotalFinishTime, waterFinishTime);
        }
        return minTotalFinishTime;
    }
}
