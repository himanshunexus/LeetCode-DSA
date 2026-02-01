class Solution {

    private long hours(int[] arr, int speed) {
        long totalHours = 0;  
        for (int ele : arr) {
            totalHours += (ele + speed - 1) / speed;
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            max = Math.max(max, i);
        }

        int low = 1, high = max;
        int speed = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (hours(piles, mid) <= h) { 
                speed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return speed;
    }
}

