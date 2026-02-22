class Solution {
    public String maximumXor(String s, String t) {
        int zero = 0 , one = 0;
        for(char c : t.toCharArray()){
            if(c == '0')
                zero++;
            else one++;
        }
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            char chosen;
            if(c == '0'){
                if( one > 0){
                    chosen = '1';
                    one--;
                }else{
                    chosen = '0';
                    zero--;
                }
            }else{
                if(zero > 0){
                    chosen = '0';
                    zero--;
                }else{
                    chosen = '1';
                    one--;
                }
            }
            if(c == chosen)
                res.append('0');
            else res.append('1');
        }
        return res.toString();
    }
}
