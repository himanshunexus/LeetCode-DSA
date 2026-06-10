class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SparseTable table = new SparseTable(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a, b) -> Integer.compare(b[0], a[0]));
        long sum = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {table.query(i, n - 1), i, n - 1});
        }

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] current = pq.poll();
            int a = current[1], b = current[2];
            sum += current[0];
            if (a < b) {
                pq.offer(new int[] {table.query(a, b - 1), a, b - 1});
            }
        }
        return sum;
    }
}

class SparseTable {
    private final int[] pow;
    private final int[][] maxTable, minTable;

    public SparseTable(int[] arr) {
        int n = arr.length;
        this.pow = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            pow[i] = pow[i >> 1] + 1;
        }
        
        int max = pow[n];
        this.maxTable = new int[max + 1][n];
        this.minTable = new int[max + 1][n];
        this.maxTable[0] = this.minTable[0] = arr;

        for (int p = 1; p <= max; p++) {
            int len = n - (1 << p), val = 1 << (p - 1);
            for (int i = 0; i <= len; i++) {
                maxTable[p][i] = Math.max(maxTable[p - 1][i], maxTable[p - 1][i + val]);
                minTable[p][i] = Math.min(minTable[p - 1][i], minTable[p - 1][i + val]);
            }
        }
    }

    public int query(int left, int right) {
        int p = pow[right - left + 1];
        int shift = right - (1 << p) + 1;
        int maxVal = Math.max(maxTable[p][left], maxTable[p][shift]);
        int minVal = Math.min(minTable[p][left], minTable[p][shift]);
        return maxVal - minVal;
    }
}
