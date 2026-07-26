class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] s1, int[][] s2) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0 , j = 0;
        int n = s1.length , m = s2.length;
        while(i < n || j < m){
            int temp;
            if(i < n && j < m){
                temp = Math.min(s1[i][0] , s2[j][0]);
            }else if(i < n){
                temp = s1[i][0];
            }else{
                temp = s2[j][0];
            }
            int v1 = 0 , v2 = 0;
            if(i < n){
                v1 = s1[i][1];
            }
            if(j < m){
                v2 = s2[j][1];
            }
            res.add(Arrays.asList(temp , v1 + v2));
            if(i < n && s1[i][0] == temp){
                i++;
            }
            if(j < m && s2[j][0] == temp){
                j++;
            }
        }
        return res;
    }
}
