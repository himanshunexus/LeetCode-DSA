class Solution {
    static final int MOD = 1_000_000_007;
    long[] fact , invFact;
    public int countVisiblePeople(int n, int pos, int k) {
        int left = pos;
        int right = n - pos -1;
        initFactorial(n + 1);
        long ans = 0;
        for(int x = 0; x <= left; x++){
            int y = k- x;
            if( y < 0 || y > right) continue;
            long ways = nCr(left , x) * nCr(right,y) % MOD;
            ans = (ans + ways) % MOD;
        }
        ans = ans * 2 % MOD;
        return (int)ans;
        
    }
    void initFactorial(int n){
        fact = new long[n + 1];
        invFact = new long[n+1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++){
            fact[i] = fact[i-1]*i%MOD;
        }
        invFact[n] = power(fact[n],MOD - 2);
        for(int i = n-1; i>=0; i--){
            invFact[i] = invFact[i+1] *(i+1) % MOD;
        }
    }
    long nCr(int n , int r){
        if(r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n-r] % MOD;
    }
    long power(long a , long b){
        long res = 1;
        while(b > 0){
            if((b & 1) == 1)
                res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
