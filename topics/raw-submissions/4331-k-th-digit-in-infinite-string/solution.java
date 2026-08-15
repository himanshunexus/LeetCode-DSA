class Solution {
    public int kthDigit(long k) {
        if(k <= 9) return (int)k;
        k -= 9;

        long len = 2 , count = 90;

        while(k > len * count){
            k -= len * count;
            len++;
            count *= 10;
        }
        long nIdx = (k - 1) / len;
        long dIdx = (k - 1) % len;
        long b = (long)Math.pow(10 , len - 2) + nIdx / 10;
        long pos = nIdx % 10;

        if(b % 2 != 0){
            pos = 9 - pos;
        }
        long target = b * 10 + pos;
        return  String.valueOf(target).charAt((int) dIdx) - '0';
    }
}
