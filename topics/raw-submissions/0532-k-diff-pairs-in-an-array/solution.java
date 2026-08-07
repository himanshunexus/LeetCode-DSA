class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Set<String> pairs = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(Math.abs(nums[i] - nums[j]) == k){
                    int min = Math.min(nums[i], nums[j]);
                    int max = Math.max(nums[i], nums[j]);
                    pairs.add(min + "," + max);
                }
            }
        }
        return pairs.size();
    }
}
