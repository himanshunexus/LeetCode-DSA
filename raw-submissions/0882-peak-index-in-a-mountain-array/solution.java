class Solution {
    public int peakIndexInMountainArray(int[] arr) {
         int i = 0 , j = arr.length - 1;

        while(i < j){
            if(arr[i] == arr[j]){
                i++;
                j--;
            } else if (arr[i] < arr[j]) {
                i++;
            }
            else{
                j--;
            }
        }
        return i;
    }
}
