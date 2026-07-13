class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0 , count = 0;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        for(int m = 0; m < n; m++){
            for(int z = m; z < n; z++){
                if(prefix[z + 1] - prefix[m] == k)
                    count++;
            }
       }
        return count;
    }
}
