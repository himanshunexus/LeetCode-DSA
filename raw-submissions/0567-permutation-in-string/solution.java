class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> s1Freq = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Freq.put(c, s1Freq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowFreq = new HashMap<>();
        
        for (int i = 0; i < s2.length(); i++) {
            char rightChar = s2.charAt(i);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);
            if (i >= s1.length()) {
                char leftChar = s2.charAt(i - s1.length());
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (windowFreq.get(leftChar) == 0) {
                    windowFreq.remove(leftChar);
                }
            }
            if (windowFreq.equals(s1Freq)) {
                return true;
            }
        }
        return false;
    }
}
