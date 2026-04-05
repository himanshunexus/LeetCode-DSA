class Solution {
    public int mirrorFrequency(String s) {
        int[] freq = new int[128];
        for(int c : s.toCharArray()){
            freq[c]++;
        }
        boolean[] vis = new boolean[128];
        int ans = 0;
        for(char c : s.toCharArray()){
            if(vis[c]) continue;
            char mirror;
            if(Character.isLetter(c)){
                mirror = (char)('a' + ('z' - c));
            }else{
                mirror = (char)('0' + ('9' - c));
            }
            ans += Math.abs(freq[c] - freq[mirror]);
            vis[c] = true;
            vis[mirror] = true;
        }
        return ans;
    }
}
