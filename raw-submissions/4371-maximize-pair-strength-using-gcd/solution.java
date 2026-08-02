class Solution {
    private long gcd(long a , long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long max = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                long a = nums[i];
                long b = nums[j];
                long g = gcd(a , b);
                long curr = (a * b) / (g * g);
                if(curr > max) max = curr;
            }
        }
        return max;
    }
}
