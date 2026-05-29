class Solution {
    public int minElement(int[] nums) {
        int sum;
        for(int i = 0; i < nums.length; i++){
            sum = 0;
            int digit = nums[i];
            while(digit > 0){
                int rem = digit % 10;
                sum += rem;
                digit /= 10;
            }
            nums[i] = sum;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            res = Math.min(res , nums[i]);
        }
        return res;
    }
}
