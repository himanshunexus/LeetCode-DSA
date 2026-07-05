class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        int totalSum = 0;
        for(int i : nums){
            int currRange = getDigitRange(i);
            if(currRange > maxRange){
                maxRange = currRange;
                totalSum = i;
            }
            else if(currRange == maxRange){
                totalSum += i;
            }
        }
        return totalSum;
    }
    private int getDigitRange(int num){
        int temp = Math.abs(num);
        if(temp == 0) return 0;
        int maxD = Integer.MIN_VALUE;
        int minD = Integer.MAX_VALUE;

        while(temp > 0){
            int digit = temp %  10;
            if(digit > maxD) maxD = digit;
            if(digit < minD) minD = digit;
            temp /= 10;
        }
        return maxD - minD;
    }
}
