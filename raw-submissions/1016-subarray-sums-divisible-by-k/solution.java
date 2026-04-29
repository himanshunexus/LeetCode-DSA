class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        long count = 0;
        int n = nums.length;
        int[] freq = new int[k];
        freq[0] = 1;
        long sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += nums[i];
            int rem = (int)((sum % k + k) % k);
            count += freq[rem];
            freq[rem]++;
        }
        return (int) count;
    }
}
