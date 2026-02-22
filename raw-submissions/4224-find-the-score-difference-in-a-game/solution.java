class Solution {
    public int scoreDifference(int[] nums) {
        int playerOne = 0;
        int playerTwo = 0;
        int active = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                active = (active == 1) ? 2 : 1;
            }
            if(i % 6 == 5){
                active = (active == 1) ? 2 : 1;
            }
            if(active == 1){
                playerOne += nums[i];
            }else{
                playerTwo += nums[i];
            }
        }
        return playerOne - playerTwo;
    }
}
