class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            int xorSum = 0;
            for (int j = left; j <= right; j++) {
                xorSum ^= arr[j];
            }
            res[i] = xorSum;
        }
        return res;
    }
}
