class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        int res = 0;
        for(int ch : set){
            int leftIdx = -1;
            int rightIdx = -1;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == ch){
                    if(leftIdx == -1){
                        leftIdx = i;
                    }
                    rightIdx = i;
                }
            }
            HashSet<Character> mid = new HashSet<>();
            for(int k = leftIdx + 1; k <= rightIdx - 1; k++){
                mid.add(s.charAt(k));
            }
            res += mid.size();
        }
        return res;
    }
}
