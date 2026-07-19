class Solution {
    public boolean canReach(int[] start, int[] target) {
        int idX = Math.abs(start[0] - target[0]);
        int idY = Math.abs(start[1] - target[1]);

        return (idX + idY) % 2 == 0;
    }
}
