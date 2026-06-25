class Solution {
    public int partitionString(String s) {
        HashSet<Character> seen = new HashSet<>();
        int ans = 1;
        
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                ans++;
                seen.clear();
            }
            seen.add(c);
        }
        return ans;
    }
}
