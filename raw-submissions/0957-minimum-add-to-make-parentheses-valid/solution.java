class Solution {
    public int minAddToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int countA = 0 , countB = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(') {
                countA++;
            }
            else if(arr[i] == ')') {
                if(countA > 0) countA--;
                else{
                    countB++;
                }
            }
        }
        int res =  countA + countB;
        return res;
    }
}
