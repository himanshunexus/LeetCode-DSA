class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length() , m = t.length();
        if(n > m) return false;
        int[] pre = new int[n + 1];
        int[] suf = new int[n + 1];
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < m && t.charAt(j) != s.charAt(i))
                j++;
            if(j < m){
                j++;
                pre[i + 1] = j;
            }else{
                pre[i + 1] = m + 1; 
            }
        }
        if(pre[n] <= m) return true;

        suf[n] = m;
        j = m;
        for(int i = n - 1; i >= 0; i--){
            while(j > 0 && t.charAt(j - 1) != s.charAt(i))
                j--;
            if(j > 0){
                j--;
                suf[i] = j;
            }else{
                suf[i] = -1;
            }
        }
        for(int i = 0; i < n; i++){
            if(suf[i + 1] >= pre[i] + 1)
                return true;
        }
        return false;
    }
}
