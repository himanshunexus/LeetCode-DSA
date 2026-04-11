class Solution {
    public int minOperations(int[] nums) {
        int totalOps = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int steps = 0;
            if(i % 2 == 0){
                while(!isPrime(num)){
                    num++;
                    steps++;
                }
            }else{
                while(isPrime(num)){
                    num++;
                    steps++;
                }
            }
            totalOps += steps;
        }
        return totalOps;
    }
    private boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i * i <= n; i += 2){
            if(n % i == 0) return false;
        }
        return true;
    }
}
