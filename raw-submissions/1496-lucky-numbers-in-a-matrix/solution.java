class Solution {
    public static int mini(int arr[]){
        int min = arr[0];
        int minIdx = 0;
        for(int i = 0;i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
    public List<Integer> luckyNumbers(int[][] matrix) {
        int idx = 0;
        List<Integer> ans = new ArrayList<>();
        
        while(idx < matrix.length){
            int minIdx = mini(matrix[idx]);
            int minVal = matrix[idx][minIdx];
            
            boolean isMin = true;
            for(int x = 0;x < matrix.length; x++){
                if(matrix[x][minIdx] > minVal){
                    isMin = false;
                    break;
                }
            }
            if(isMin){
                ans.add(minVal);
            }
            idx++;
        }
        return ans;
    }
}
