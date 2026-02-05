class Solution {
    public boolean isPerfect(int n){
        int sqrt = (int)(Math.sqrt(n));
        return (sqrt*sqrt == n);
    }
    public int numSquares(int n) {
      int[] res = new int[n+1];
      for(int i = 1; i <= n; i++){
        if(isPerfect(i)){
            res[i] = 1;
        }
        else{
            int min = Integer.MAX_VALUE;
            for(int k = 1; k * k <= i; k++){
                int count = 1 + res[ i - k * k];
                min = Math.min(min,count);
            }
            res[i] = min;
        }
      }
      return res[n];  
    }
}
