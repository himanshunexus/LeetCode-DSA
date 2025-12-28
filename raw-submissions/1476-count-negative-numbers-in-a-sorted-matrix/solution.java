class Solution {
    private int count(int[] row) {
        int n = row.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (row[mid] < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return n - start;
    }
    public int countNegatives(int[][] grid) {
        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            total += count(grid[i]);
        }

        return total;
    }
}

