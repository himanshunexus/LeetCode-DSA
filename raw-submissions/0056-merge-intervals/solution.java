class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);
        int n = intervals.length , idx = 0;
        int[][] res = new int[n][2];
        res[0] = intervals[0];
        for(int i = 1; i < n; i++){
            if(res[idx][1] < intervals[i][0]){
                idx++;
                res[idx] = intervals[i];
            }
            else{
                res[idx][1] = Math.max(res[idx][1],intervals[i][1]);
            }
        }
        return Arrays.copyOf(res , idx + 1);
    }   
}
