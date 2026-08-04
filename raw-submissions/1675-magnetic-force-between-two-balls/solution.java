class Solution {
    private boolean possible(int[] position, int mid, int m) {
        int count = 1;
        int lastPlaced = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= mid) {
                count++;
                lastPlaced = position[i];
                if (count >= m) {
                    return true;
                }
            }
        }
        return count >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (possible(position, mid, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
