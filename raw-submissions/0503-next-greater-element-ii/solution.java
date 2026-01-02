class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> st = new Stack<>();
        
        for(int i = len-1; i >= 0; i--){
            st.push(nums[i]);
        }
        
        int[] narr = new int[len];
        
        for(int i = len-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                narr[i] = -1;
            } else {
                narr[i] = st.peek();
            }
            
            st.push(nums[i]);
        }
        
        return narr;
    }
}
