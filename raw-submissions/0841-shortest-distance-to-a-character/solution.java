class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] arr = s.toCharArray();
        int[] ans = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            min = Integer.MAX_VALUE;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == c){
                    int curr = Math.abs(j - i);
                    min = Math.min(curr , min);
                }
                ans[i] = min;
            }
        }
        return ans;
    }
}
