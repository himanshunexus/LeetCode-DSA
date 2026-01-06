class Solution {
    public int mySqrt(int n) {
        int low =0;
        int high =n;
        while(low<=high){
            long mid = (low+high)/2;
            if(mid * mid == n)
                return (int)mid;
            else if(mid*mid > n)
                high =  (int)mid-1;
            else 
                low =  (int)mid+1;
        }
        return (int)high;
    }
}

