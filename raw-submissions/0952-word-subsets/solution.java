class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] count = countFreq(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], count[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String a : words1) {
            int[] count = countFreq(a);
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                ans.add(a);
            }
        }

        return ans;
    }
    private int[] countFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
