class Solution {
    public int firstMatchingIndex(String s) {
        char[] arr = s.toCharArray();
        int minIdx = Integer.MAX_VALUE;
        int idx = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == arr[arr.length-i-1]){
                idx = i;
                minIdx = Math.min(minIdx,idx);
            }
        }
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
}
