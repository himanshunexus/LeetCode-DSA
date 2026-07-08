class Solution {
    public boolean halvesAreAlike(String s) {
        char[] arr = s.toCharArray();
        int n = (arr.length / 2) , m  = arr.length;
        String vowel = "aeiouAEIOU";
        int countOne = 0;
        int countTwo = 0;
        for(int i = 0; i < n; i++){
            if(vowel.contains(arr[i] + "")){
                countOne++;
            }
        }
        for(int i = n; i < m; i++){
            if(vowel.contains(arr[i] + "")){
                countTwo++;
            }
        }
        return countOne == countTwo;
    }
}
