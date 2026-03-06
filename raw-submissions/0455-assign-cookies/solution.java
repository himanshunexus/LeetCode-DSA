class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n  = s.length , m = g.length;
        int count = 0;
        int j = 0;  
        
        for(int i = 0; i < m; i++){
            for(; j < n; j++){  
                if(s[j] >= g[i]) {
                    count++;
                    j++;  
                    break;  
                }
            }
        }
        return count;
    }
}

