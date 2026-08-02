class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + tasks[i];
        }
        long total = prefix[n];
        int m = shifts.length;
        int[] ans = new int[m];
        long done = 0;
        for(int j = 0; j < m; j++){
            long t = shifts[j];
            if(done + t >= total){
                done = 0;
                ans[j] = 0;
            }
            else{
                done = done + t;
                int lo = 0;
                int hi = n;
                while(lo < hi){
                    int mid = (lo + hi + 1) / 2;
                    if(prefix[mid] <= done){
                        lo = mid;
                    }else{
                        hi = mid - 1;
                    }
                }
                ans[j] = n - lo;
            }
        }
        return ans;
    }
}
