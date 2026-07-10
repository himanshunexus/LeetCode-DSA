class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int level = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '('){
                if(level > 0){
                    str.append(ch);
                }
                level++;
            }
            else if(ch == ')'){
                level--;
                if(level > 0){
                    str.append(ch);
                }
            }
        }
        return str.toString();
    }
}
