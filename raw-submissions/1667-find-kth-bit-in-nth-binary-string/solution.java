class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");
        for(int i = 2; i <= n; i++){
            String prev = str.toString();
            StringBuilder nextStr = new StringBuilder();
            for(int j = prev.length() - 1; j >= 0; j--){
                if(prev.charAt(j) == '0'){
                    nextStr.append('1');
                }else{
                    nextStr.append('0');
                }
            }
            str.append('1');
            str.append(nextStr);
        }
        return str.charAt(k-1);
    }
}
