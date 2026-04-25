class Solution {
    public boolean validDigit(int n, int x) {
        int temp = n;
        while(temp >= 10)
            temp /= 10;
        if(temp == x ) return false;
        while(n > 0){
            if(n % 10 == x)
                return true;
            n /= 10;
        }
        return false;
    }
}
