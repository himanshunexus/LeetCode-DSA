class Solution {
    public boolean isVol(char k){
        if(k == 'a' || k == 'A' || k == 'e'|| k == 'E' || k == 'i' || k == 'I' || k == 'o' || k == 'O' || k == 'u' || k == 'U') return true;
        return false;
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0 , right = arr.length - 1;
        while(left < right){
            if(isVol(arr[left]) && isVol(arr[right])){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            left++;
            right--;
            }else if (!isVol(arr[left])) {
                left++;
            } else {
                right--;
            }
        }
        return new String(arr);
    }
}
