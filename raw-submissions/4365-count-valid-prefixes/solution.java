class Solution {
    public int countValidPrefixes(String s) {
        int count0 = 0;
        int count1 = 0;
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '0') count0++;
            else if(ch == '1') count1++;
            if(Math.abs(count0 - count1) <= 1) ans++;
        }
        return ans;
    }
}
