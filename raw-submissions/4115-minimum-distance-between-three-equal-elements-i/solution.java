class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int res = Integer.MAX_VALUE;
        
        int targetI = 0, targetII = 0, targetIII = 0;

        for (int i = 0; i < n; i++) {
            targetI = nums[i];
            int first = i;
            for (int k = i + 1; k < n; k++) {
                if (targetI == nums[k]) {
                    targetII = nums[k];
                    int sec = k;
                    for (int z = k + 1; z < n; z++) {
                        if (targetII == nums[z]) {
                            targetIII = nums[z];
                            int thrd = z;
                            
                            ans = Math.abs(first - sec) + Math.abs(sec - thrd) + Math.abs(thrd - first);
                            res = Math.min(ans, res);
                        }
                    }
                }
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
