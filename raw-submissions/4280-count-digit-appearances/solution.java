class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
       int count = 0;
        for(int num : nums){
            int temp = num;
            if(temp == 0 && digit == 0){
                count++;
            }
            while(temp > 0){
                if(temp % 10 == digit){
                    count++;
                }
                temp /= 10;
            }
        }
        return count;
    }
}
