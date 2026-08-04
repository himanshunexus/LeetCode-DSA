class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int start = nums[0] , end = nums[n - 1];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = start; i <= end; i++){
            ans.add(i);
        }
        for(int i = 0; i < n; i++){
            if(ans.contains(nums[i]))
                ans.remove(Integer.valueOf(nums[i]));
        }
        return ans;
    }
}
