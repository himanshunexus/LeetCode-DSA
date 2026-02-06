class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        for(int k =0; k < heights.length; k++){
            expected[k] = heights[k];
        }
        Arrays.sort(expected);
        int count = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }
}
