class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int j = n - 1;
            int count = 0;
            while(j >= 0 && grid[i][j] == 0){
                count++;
                j--;
            }
            res[i] = count;
        }

            int step = 0;
            for(int i = 0; i < n; i++){
                int need = n - i -1;
                int j = i;
                while(j < n && res[j] < need){
                    j++;
                }
                if(j == n){
                    return -1;
                }
                while( j > i){
                    int temp = res[j];
                    res[j] = res[j - 1];
                    res[j - 1] = temp;
                    j--;
                    step++;
                }
            }
        return step;
    }
}
