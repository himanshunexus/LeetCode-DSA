class Solution {
    public int minAddToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int countA = 0 , countB = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(') {
                countA++;
            }
            else if(arr[i] == ')') {
                if(countA > 0) countA--;
                else{
                    sb.append(arr[i]);
                }
            }
        }
        int extra = sb.length();
        int res =  countA + extra;
        return res;
    }
}
