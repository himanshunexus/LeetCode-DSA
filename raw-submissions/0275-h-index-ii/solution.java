class Solution {
    public int helper(int[] citations , int guess){
        int count = 0 , n = citations.length; 
        for(int i = 0; i < n; i++){
            if(citations[i] >= guess) count++;
        }
        return count;
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int left = 1 , right = citations[n - 1] , ans = 0;
        while(left <= right){
            int guess = left + (right - left) / 2;
            int count = helper(citations , guess);
            if(count >= guess){
                left = guess + 1;
                ans = guess;
            }
            else{
                right = guess - 1;
            }
        }
        return ans;
    }
}
