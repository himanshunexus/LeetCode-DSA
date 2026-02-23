class Solution {
    public boolean hasAllCodes(String s, int k) {
        int requiredCount = 1 << k;
        if (s.length() < requiredCount + k - 1) {
            return false;
        }
        Set<String> visit = new HashSet<>();
        for (int i = k; i <= s.length(); i++) {
            String sub = s.substring(i - k, i);
            visit.add(sub);
            if (visit.size() == requiredCount) {
                return true;
            }
        }
        return false;
    }
}
