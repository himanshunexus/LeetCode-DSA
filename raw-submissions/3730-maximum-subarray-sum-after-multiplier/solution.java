class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long NEG = Long.MIN_VALUE / 4;
        long before = NEG;
        long insideMul = NEG , afterMul = NEG;
        long insideDiv = NEG , afterDiv = NEG;
        long ans = NEG;
        for(int x : nums){
            long  vm  = (long) x * k;
            long vd = x / k;

            long newInsideMul = Math.max(Math.max(insideMul + vm , before + vm) , vm);
            long newAfterMul = Math.max(afterMul + x , insideMul + x);
            long newInsideDiv = Math.max(Math.max(insideDiv + vd , before + vd) , vd);
            long newAfterDiv = Math.max(afterDiv  +x , insideDiv + x);

            before = Math.max(before + x, x);
            insideMul = newInsideMul;
            afterMul = newAfterMul;
            insideDiv = newInsideDiv;
            afterDiv = newAfterDiv;

            ans = Math.max(ans , Math.max(before , Math.max(Math.max(insideMul , afterMul),Math.max(insideDiv , afterDiv))));
        }
        return ans;
    }
}
