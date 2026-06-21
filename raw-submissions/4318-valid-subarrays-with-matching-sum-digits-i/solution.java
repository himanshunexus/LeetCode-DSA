class Solution {
    public int countValidSubarrays(int[] nums, int x) {
       int n = nums.length;
        long[] pre = new long[n];
        pre[0] = nums[0];

        for(int i = 1; i < n; i++){
            pre[i] = pre[i - 1] + nums[i];
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                long sum = pre[j] - (i > 0 ? pre[i - 1] : 0);
                if(first(sum) == x && sum % 10 == x){
                    ans++;
                }
            }
        }
        return ans;
    }
    private int first(long n){
        while(n >= 10){
            n /= 10;
        }
        return (int) n;
    }
}
