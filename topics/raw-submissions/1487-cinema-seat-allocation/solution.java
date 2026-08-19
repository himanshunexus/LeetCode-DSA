class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        int result = (n - map.size()) * 2;

        int maskA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int maskB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int maskC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int bookedSeatsMask : map.values()) {
            boolean groupA = (bookedSeatsMask & maskA) == 0;
            boolean groupB = (bookedSeatsMask & maskB) == 0;
            boolean groupC = (bookedSeatsMask & maskC) == 0;

            if (groupA && groupC) {
                result += 2;
            } else if (groupA || groupB || groupC) {
                result += 1;
            }
        }
        
        return result;
    }
}
