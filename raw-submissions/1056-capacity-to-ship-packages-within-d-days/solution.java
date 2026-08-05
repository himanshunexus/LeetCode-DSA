class Solution {
    public boolean canShip(int[] weights, int mid ,int days){
        int count = 1;
        int currLoad = 0;
        for(int curr : weights){
            if(currLoad + curr > mid){
                count++;
                currLoad = 0;
            }
            currLoad += curr;
        }
        return count <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left = 0;
        int right = 0;
        for(int w : weights){
            left = Math.max(left, w);
            right += w;
        }
        int ans =right;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canShip(weights , mid , days)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
