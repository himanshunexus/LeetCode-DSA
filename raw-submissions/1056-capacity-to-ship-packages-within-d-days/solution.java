class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w); 
            high += w;               
        }
        int answer = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (canShip(weights, mid, days)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean canShip(int[] weights, int capacity, int days) {
        int daysNeeded = 1;
        int currentLoad = 0;
        
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return daysNeeded <= days;
    }
}
