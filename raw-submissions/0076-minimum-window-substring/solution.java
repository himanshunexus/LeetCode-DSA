class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        StringBuilder parentStr = new StringBuilder(s);
        StringBuilder childStr  = new StringBuilder(t);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < childStr.length(); i++) {
            char c = childStr.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int required = t.length();
        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        for (int right = 0; right < parentStr.length(); right++) {
            char rc = parentStr.charAt(right);
            if (map.containsKey(rc)) {
                if (map.get(rc) > 0) required--;
                map.put(rc, map.get(rc) - 1);
            }

            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char lc = parentStr.charAt(left);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : parentStr.substring(minStart, minStart + minLen).toString();
    }
}

