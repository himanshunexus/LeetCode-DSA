class Solution {
    public boolean possible(int[] quantities , int mid , int n){
        for(int p : quantities){
            n -= (p + mid - 1) / mid;
            if(n < 0) return false;
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = 0;
        for(int i : quantities){
            r = Math.max(r , i);
        }
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(possible(quantities , mid , n)){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
