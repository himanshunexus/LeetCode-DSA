class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currTime = 0;
        long totalWait = 0;
        for(int i = 0; i < customers.length; i++){
            int arrival = customers[i][0];
            int time = customers[i][1];
            if(currTime < arrival){
                currTime = arrival;
            }
            currTime += time;
            totalWait +=(currTime - arrival);
        }
        return (double)totalWait/customers.length;
    }
}
