class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int length = 0;
        boolean hasOdd = false;
        for (int freq : map.values()) {
            length += (freq / 2) * 2;
            if (freq % 2 == 1)
                hasOdd = true;
        }
        if (hasOdd)
            length += 1;

        return length;
    }
}

