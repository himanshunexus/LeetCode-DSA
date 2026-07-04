class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0 , right = n - 1;
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(!isValid(l)) left++;
            else if(!isValid(r)) right--;
            else{
                if((l != r) && (!isMatch(l , r))) return false;
                left++;
                right--;
            }
        }
        return true;
    }
    private static boolean isValid(char c){
        return (c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122);
    }
    private static boolean isMatch(char l , char r){
        if (l >= 65 && l <= 90) l += 32;
        if (r >= 65 && r <= 90) r += 32;
        return l == r;
    }
}
