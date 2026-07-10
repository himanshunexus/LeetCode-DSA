class Solution {
    public int beautySum(String s) {
        int ans = 0; 
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> mp = new HashMap<>(); 
            for (int j = i; j < s.length(); j++) {
                char v = s.charAt(j);
                mp.put(v, mp.getOrDefault(v, 0) + 1); 
                
                int high = Collections.max(mp.values()); 
                int low = Collections.min(mp.values()); 
                
                ans += high - low; 
            } 
        } 
        return ans; 
    }
}
