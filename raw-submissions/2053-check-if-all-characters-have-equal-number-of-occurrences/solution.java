class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[128];
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            count[ch]++;
        }
        int freq = 0;
        for(int i =0;i<128;i++){
            if(count[i]>0){
                freq = count[i];
                break;
            }
        }
        for(int i = 0;i<128;i++){
            if(count[i]>0 && count[i]!=freq){
                return false;
            }
        }
        return true;
    }
}
