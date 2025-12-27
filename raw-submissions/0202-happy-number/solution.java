class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> res = new HashSet<>();
        while(n!=1 && !res.contains(n)){
            res.add(n);
            n = squareSum(n);
        }
        return n==1;
    }
    private int squareSum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum+= digit * digit;
            n/=10;
        }
        return sum;
    }
}
