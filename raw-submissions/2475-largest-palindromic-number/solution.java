class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        for(char c : num.toCharArray()){
            count[c - '0']++;
        }
        String middle = "";
        StringBuilder half = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            if(count[i] % 2 == 1 && middle.equals("")){
                middle = String.valueOf(i);
            }

            for(int j = 0; j < count[i] / 2; j++){
                half.append(i);
            }
        }

        while(half.length() > 0 && half.charAt(0) == '0'){
            half.deleteCharAt(0);
        }

        String first = half.toString();
        String second = new StringBuilder(first).reverse().toString();

        String result = first + middle + second;
        if(result.length() == 0) return "0";
        return result;
    }
}
