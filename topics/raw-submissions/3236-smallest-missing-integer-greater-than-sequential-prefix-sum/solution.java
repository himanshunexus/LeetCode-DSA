class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int curr = nums[0];
        for(int right = 1; right < nums.length; right++){
            if(nums[right] - curr == 1){
                sum += nums[right];
                curr = nums[right];
            }
            else {
                break;
            } 
        }
        Arrays.sort(nums);
        int res = sum;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == res){
                res++;
            }
        }
        return res;
    }
}
