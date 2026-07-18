class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder countX = new StringBuilder();
        StringBuilder countY = new StringBuilder();
        StringBuilder ext = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == y){
                countY.append(ch);
            }
            else if(ch == x){
                countX.append(ch);
            }
            else{
                ext.append(ch);
            }
        }
        return countY.append(ext).append(countX).toString();
    }
}
