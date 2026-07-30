class Solution {
    public boolean possible(int[] time, long givenTime ,int totalTrips){
        long actualTrip = 0;
        for(int t : time){
            actualTrip += givenTime / t;
        }
        return actualTrip >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long minTime = time[0];
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        long low = 1;
        long high = minTime * totalTrips;

        while(low < high){
            long mid = low + (high - low) / 2;
            if(possible(time , mid , totalTrips)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
