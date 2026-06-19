class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int low = 1, high = 0;
        
        for (int c : candies) {
            high = Math.max(high, c);
        }
        
        int answer = 0;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canAllocate(candies , mid , k)){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return answer;
    }

    private boolean canAllocate(int[] candies, int capacity, long k) {
        long totalPiles = 0;
        
        for (int c : candies) {
            totalPiles += (c / capacity);
        }
        return totalPiles >= k;
    }
}
