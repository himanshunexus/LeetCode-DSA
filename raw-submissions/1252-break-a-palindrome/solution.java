class Solution {
    public String breakPalindrome(String palindrome) {
        String res = ""; 
        char[] arr = palindrome.toCharArray(); 
        int n = arr.length; 
        if(n == 0 || n == 1) return res; 
        
        for(int i = 0; i < n / 2; i++){
            if(arr[i] - 'a' > 0){
                arr[i] = 'a'; 
                return new String(arr); 
            } 
        } 
        arr[n - 1] = 'b';
        return new String(arr); 
    } 
}
