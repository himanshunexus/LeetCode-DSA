class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0 , maxPrefix = 0 , prefix = 0;
        for(int diff : differences){
            prefix += diff;
            minPrefix = Math.min(prefix , minPrefix);
            maxPrefix = Math.max(prefix , maxPrefix);
        }
        long range = upper - lower;
        long need = maxPrefix - minPrefix;
        long ans = range - need + 1;
        return ans > 0 ? (int)ans : 0;
    }
}
