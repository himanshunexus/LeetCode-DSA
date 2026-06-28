class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] a, int fs, int fe) {
        Arrays.sort(a , (x , y )-> x[0] - y[0]);
        List<List<Integer>> ans = new ArrayList<>();
        int l = a[0][0] , r = a[0][1];
        for(int i = 1; i  < a.length; i++){
            if(a[i][0] > r + 1){
                add(ans , l , r , fs , fe);

                l = a[i][0];
                r = a[i][1];
            }else{
                r = Math.max(r , a[i][1]);
            }
        }
        add(ans , l , r, fs , fe);
        return ans;
    }
    private void add(List<List<Integer>> ans , int l , int r , int fs , int fe){
        if(r < fs|| l > fe){
            ans.add(Arrays.asList(l , r));
        }else{
            if(l < fs) ans.add(Arrays.asList(l , fs - 1));
            if(r > fe) ans.add(Arrays.asList(fe + 1 , r));
        }
    }
}
