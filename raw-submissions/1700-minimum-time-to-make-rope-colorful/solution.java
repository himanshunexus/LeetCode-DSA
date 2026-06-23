class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int n = arr.length , res = 0;
        int prevMax = 0;

        for(int i = 0; i < n; i++){
            if(i > 0 && arr[i] != arr[i - 1]){
                prevMax = 0;
            }
            int curr = neededTime[i];
            res += Math.min(prevMax , curr);
            prevMax = Math.max(prevMax , curr);
        }
        return res;
    }
}
