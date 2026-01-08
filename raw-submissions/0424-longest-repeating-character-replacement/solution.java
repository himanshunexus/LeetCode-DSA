class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int n = s.length();
        int freq = 0;
        int maxLen = 0;
        for(int right =0;right<n;right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            freq = Math.max(freq , map.get(s.charAt(right)));

            while((right - left +1) - freq > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);

            if(map.get(s.charAt(left))==0){
                map.remove(s.charAt(left));
            }
            left++;
        }
        maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}

