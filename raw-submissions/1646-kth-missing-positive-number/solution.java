class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int[] missing = new int[k];
        int arrIdx = 0;
        int mIdx = 0;

        for (int count = 1; mIdx < k; count++) {
            if (arrIdx < n && arr[arrIdx] == count) {
                arrIdx++;
            } else {
                missing[mIdx] = count;
                mIdx++;
            }
        }

        return missing[k - 1];
    }
}
