class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, tank = 0;
        int startIndex = 0, totalGas = 0, totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        return totalGas < totalCost ? -1 : startIndex;
    }
}
