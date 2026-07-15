class Solution {
    public static int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int eveSum = n * n;
        int oddSum = n * ( n + 1);
        int res = gcd(oddSum , eveSum);
        return res;
    }
}
