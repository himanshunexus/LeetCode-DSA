class Solution {
    public String smallestPalindrome(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder part1 = new StringBuilder();
        String mid = "";

        for (char ch : map.keySet()) {
            int count = map.get(ch);

            for (int i = 0; i < count / 2; i++) {
                part1.append(ch);
            }
            if (count % 2 != 0) {
                mid = String.valueOf(ch);
            }
        }

        StringBuilder part2 = new StringBuilder(part1);
        part2.reverse();

        StringBuilder res = new StringBuilder();
        res.append(part1).append(mid).append(part2);

        return res.toString();
    }
}

