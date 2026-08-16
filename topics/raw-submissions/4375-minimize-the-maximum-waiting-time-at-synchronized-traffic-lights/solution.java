class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxG = 0;
        for(int l : lights){
            if(l > maxG){
                maxG = l;
            }
        }
        int maxP = 0;
        for(int t : arrivalTime){
            int r = t % period;
            if(r >= maxG){
                int wait = period - r;
                if(wait > maxP){
                    maxP = wait;
                }
            }
        }
        return maxP;
    }
}
