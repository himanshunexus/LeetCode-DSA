public class Solution {
    public int countBinarySubstrings(String s) {
        int current = 1;
        int previous = 0;
        int result = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
            } else {
                result += Math.min(previous, current);
                previous = current;
                current = 1;
            }
        }
        return result + Math.min(previous, current);
    }
}
