class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> map = new HashMap<>();
        char[] arr = key.toCharArray();
        char alphabet = 'a';
        
        for(char ch : arr){
            if(ch != ' ' && !map.containsKey(ch)){
                map.put(ch, alphabet);
                alphabet++;
            }
        }
        
        String res = "";
        char[] msgArr = message.toCharArray();
        
        for(char msg : msgArr){
            if(msg == ' '){
                res += ' ';
            } else {
                res += map.get(msg);
            }
        }
        
        return res;
    }
}
