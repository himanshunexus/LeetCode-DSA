class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long mod = 1_000_000_007L;
        long count0 = 0 , count1 = 0 , count2 = 0 , totalSwaps = 0;
        for(int num : nums){
            if(num < a){
                totalSwaps += (count1 + count2);
                count0++;
            }
            else if(num >= a && num <= b){
                totalSwaps += count2;
                count1++;
            }
            else{
                count2++;
            }
        }
        return (int)(totalSwaps % mod);
    }
}
