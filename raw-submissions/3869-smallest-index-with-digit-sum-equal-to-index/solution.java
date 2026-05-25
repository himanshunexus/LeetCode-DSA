class Solution {
    public int findSum(int num){
        if(num == 0) return 0;
        int res = 0;
        while(num > 0){
            res += num % 10;
            num /= 10;
        }
        return res;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length , sum = 0;
        for(int i = 0; i < n; i++){
            sum = findSum(nums[i]);
            if(sum == i) return i;
        }
        return -1;
    }
}
