class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int left = 0;
        int right = 1000000000;
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(tasks, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    private boolean canFinish(int[][] tasks, int energy) {
        for (int[] task : tasks) {
            if (energy < task[1]) return false;
            energy -= task[0];
        }
        return true;
    }
}
