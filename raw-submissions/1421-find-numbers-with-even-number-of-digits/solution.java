class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
       for(int i = 0; i < nums.length; i++){
        int ele = nums[i];
        int count = 0;
        while(ele != 0 ){
            count++;
            ele /= 10;
        }
        if(count % 2==0){
            ans++;
            }
        }
        return ans;
    }
}
