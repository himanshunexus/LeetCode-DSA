class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (vowel.indexOf(arr[left]) < 0) left++;
            else if (vowel.indexOf(arr[right]) < 0) right--;
            else {
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        return new String(arr);
    }
}

