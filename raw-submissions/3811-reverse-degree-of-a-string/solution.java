class Solution {
    public int reverseDegree(String s) {
        int len = s.length();
        int res=0;
        for(int i=0; i<len; i++){
                 int prod = ('z'-s.charAt(i)+1)*(i+1);
                 res+=prod;
            }
        return res;
    }
}
