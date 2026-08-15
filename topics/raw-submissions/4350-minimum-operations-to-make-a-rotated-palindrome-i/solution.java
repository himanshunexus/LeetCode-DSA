class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            String rot = s.substring(i) + s.substring(0 , i);
            int curr = i;
            int left = 0 , right = n - 1;
            while(left < right){
                char c1 = rot.charAt(left);
                char c2 = rot.charAt(right);

                if(c1 != c2){
                    int cost1 = (c2 - c1 + 26) % 26;
                    int cost2 = (c1 - c2 + 26) % 26;
                    curr += Math.min(cost1 , cost2);
                }
                left++;
                right--;
            }
            min = Math.min(min , curr);
        }
        return min;
    }
}
