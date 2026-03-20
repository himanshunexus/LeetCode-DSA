class Solution {
    public boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();
        while(arr.length > 2){
            char[] next = new char[arr.length - 1];
            for(int i = 0; i < next.length; i++){
                int numA = arr[i] - '0';
                int numB = arr[i+1] - '0';
                int sum = ((numA + numB) % 10);
                next[i] = (char)(sum + '0');
            }
            arr = next;
        }
        return arr[0] == arr[1];
    }
}
