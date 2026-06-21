class Solution {
    public int maxDistance(String moves) {
        int u = 0 , d = 0 , l = 0 , r = 0, q = 0;
        for(char c : moves.toCharArray()){
            if(c =='U') u++;
            else if(c == 'D') d++;
            else if(c == 'L') l++;
            else if(c == 'R') r++;
            else q++;
        }
        int x = r - l;
        int y = u - d;
        return Math.abs(x) + Math.abs(y) + q;
    }
}
