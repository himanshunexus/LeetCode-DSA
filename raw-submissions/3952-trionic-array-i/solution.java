class Solution {
    public boolean isTrionic(int[] arr) {
        int n = arr.length;
        if (n < 4) return false;
        int i = 1;
        while (i < n && arr[i] > arr[i - 1]) i++;
        if (i == 1 || i == n) return false;
        while (i < n && arr[i] < arr[i - 1]) i++;
        if (i == n) return false;
        while (i < n && arr[i] > arr[i - 1]) i++;
        return i == n;
    }
}
