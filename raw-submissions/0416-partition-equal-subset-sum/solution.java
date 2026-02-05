class Solution {
    private static boolean subset(int idx, int[] nums,int target,int[][] res){
        if(idx == nums.length){
            if(target == 0) return true;
            else return false;
        }
        if(res[idx][target]!=-1) return (res[idx][target]==1);
        boolean ans = false;
        boolean skip = subset(idx+1,nums,target,res);
        if(target - nums[idx] < 0 ) ans = skip;
        else{
            boolean pick = subset(idx+1,nums,target - nums[idx],res);
            ans = pick || skip;
        }
        res[idx][target] = ans ? 1 : 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int[][] res = new int[nums.length][target + 1];
        
        for (int[] row : res) Arrays.fill(row, -1);

        return subset(0, nums, target, res);
    }
}
