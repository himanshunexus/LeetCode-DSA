class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        int ans = 0;
        
        for (String w : words) {
            String rev = new StringBuilder(w).reverse().toString();
            if (count.getOrDefault(rev, 0) > 0) {
                ans += 4;
                count.put(rev, count.get(rev) - 1);
            } else {
                count.put(w, count.getOrDefault(w, 0) + 1);
            }
        }
        
        for (String w : count.keySet()) {
            if (w.charAt(0) == w.charAt(1) && count.get(w) > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}
