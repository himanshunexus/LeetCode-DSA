class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            int even = 0 , odd = 0;
            for(int j = i; j < n; j++){
                if(nums[j] % 2 == 0) even++;
                else odd++;
                if(odd > 0 && (long)even * b <= (long)odd * a)
                    total++;
            }
        }
        return total;
    }
}
