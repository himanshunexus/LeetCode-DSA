class Solution {
    long M = 1000000007;
    public int countValidSequences(int n, int k) {
        if(k > n) return 0;
        long[] fac = new long[n + 5];
        long[] inversefac = new long[n  +5];
        fac[0] = 1;
        inversefac[0] = 1;
        for(int i = 1; i <= n; i++){
            fac[i] = (fac[i - 1] * i) % M;
        }
        inversefac[n] = pow(fac[n] , M - 2);
        for(int i = n - 1; i >= 1; i--){
            inversefac[i] = (inversefac[i + 1] * (i + 1)) % M;
        }
        long total = nCr(n - 1 , k - 1 , fac ,inversefac);
        long odd = 0;
        if((n - k) % 2 == 0){
            odd = nCr((n - k) / 2 + k - 1 , k - 1, fac , inversefac);
        }
        long ans = (total - odd + M) % M;
        return (int)ans;
    }
    private long nCr(int n , int r , long[] fac , long[] inversefac){
        if(r > n || r < 0) return 0;
        long num = fac[n];
        long den = (inversefac[r] * inversefac[n - r]) % M;
        return (num * den) % M;
    }
    private long pow(long b , long e){
        long r = 1;
        b = b % M;
        while(e > 0){
            if(e % 2 == 1){
                r = (r * b) % M;
            }
            b = (b * b) % M;
            e /= 2;
        }
        return r;
    }
}
