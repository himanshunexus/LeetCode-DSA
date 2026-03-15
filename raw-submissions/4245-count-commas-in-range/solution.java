class Solution {
    public int countCommas(int n) {
        long res = 0;
        long start = 1000;
        long comma = 1;
        while(start <= n){
            long end = Math.min(n , start * 1000 - 1);
            res += (end - start + 1) * comma;
            start *= 1000;
            comma++;
        }
        return (int)res;
    }
}
