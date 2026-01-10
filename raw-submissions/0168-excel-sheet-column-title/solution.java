class Solution {
    public String convertToTitle(int columnNumber) {
        String str="";
        while( columnNumber > 0){
            columnNumber--;

            char rem = (char)('A'+columnNumber % 26);
            str =rem+str;
            columnNumber/=26;

        }
        return str;
    }
}
