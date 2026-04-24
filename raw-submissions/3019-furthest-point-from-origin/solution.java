class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int counts = 0, wild = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') counts--;
            else if (c == 'R') counts++;
            else wild++;
        }
        return Math.abs(counts) + wild;
    }
}
