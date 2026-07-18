class Solution {
    private static int gcd(int a , int b){
         while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sNum = nums[0];
        int lNum = nums[n - 1];
        int ans = gcd(sNum , lNum);
        return ans;
    }
}
