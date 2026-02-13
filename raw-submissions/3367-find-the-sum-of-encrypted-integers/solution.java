class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for(int x : nums){
            int maxDigit = 0;
            int count = 0;
            int temp = x;
            while(temp > 0){
                int rem = temp % 10;
                maxDigit = Math.max(maxDigit,rem);
                temp /= 10;
                count++;
            }
            int ans = 0;
            while( count > 0){
                ans = ans * 10 + maxDigit;
                count--;
            }
            sum += ans;
        }
        return sum;
    }
}
