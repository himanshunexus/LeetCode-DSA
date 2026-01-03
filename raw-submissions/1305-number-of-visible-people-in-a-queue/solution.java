class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int len = heights.length;
        int[] ans = new int[len];
        for(int i = len-1; i>=0; i--){
            int count = 0;
            while(!st.isEmpty() && st.peek() <= heights[i]){
                st.pop();
                count++;
            }
              if (!st.isEmpty()) {
                count++;
            }

            ans[i] = count;
            st.push(heights[i]);
        }
        return ans;
    }
}
