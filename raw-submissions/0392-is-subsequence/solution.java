class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1 = t.length();
        int len2 = s.length();
        int count=0;
        int i=0;
        int j=0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
                count++;
            }
            else{
                j++;
                
            }
        }
        return len2 == count;
    }
}
