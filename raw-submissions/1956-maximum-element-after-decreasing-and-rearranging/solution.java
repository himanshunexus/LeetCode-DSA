class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        for (int val : arr) {
            max = Math.min(max + 1, val);
        }
        return max;
    }
}
