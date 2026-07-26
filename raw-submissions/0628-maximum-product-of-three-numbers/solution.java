class Solution {
    public int maximumProduct(int[] nums) {
        int maxOne = Integer.MIN_VALUE, maxTwo = Integer.MIN_VALUE, maxThree = Integer.MIN_VALUE;
        int minOne = Integer.MAX_VALUE, minTwo = Integer.MAX_VALUE;
        int curr;

        for(int i = 0; i < nums.length; i++) {
            curr = nums[i];
            if(curr > maxOne) {
                maxThree = maxTwo;
                maxTwo = maxOne;
                maxOne = curr;
            }
            else if(maxTwo < curr) {
                maxThree = maxTwo;
                maxTwo = curr;
            }
            else if(maxThree < curr) {
                maxThree = curr;
            }
            if(curr < minOne) {
                minTwo = minOne;
                minOne = curr;
            }
            else if(minTwo > curr) {
                minTwo = curr;
            }
        }
        return Math.max(maxThree * maxTwo * maxOne, minOne * minTwo * maxOne);
    }
}
