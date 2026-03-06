class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder res = new StringBuilder();
        
        ans.append(s).reverse();
        String[] words = ans.toString().split("\\s+"); 
        
        for(String word : words) {
            if(!word.isEmpty()) { 
                res.append(new StringBuilder(word).reverse()).append(" ");
            }
        }
        return res.toString().trim();
    }
}

