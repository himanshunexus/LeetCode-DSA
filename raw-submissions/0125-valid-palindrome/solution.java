class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (!isValid(l)) {
                left++;
            } else if (!isValid(r)) {
                right--;
            } else {
                if (l != r && !isMatch(l, r)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
    private boolean isValid(char c) {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
    private boolean isMatch(char c1, char c2) {
        if (c1 >= 65 && c1 <= 90) c1 += 32;
        if (c2 >= 65 && c2 <= 90) c2 += 32;
        return c1 == c2;
    }
}
