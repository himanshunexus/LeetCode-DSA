class Solution {
    public int maxDistinct(String s) {
        boolean[] seen = new boolean[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!seen[ch - 'a']) {
                seen[ch - 'a'] = true;
                count++;
            }
        }
        return count;
    }
}
