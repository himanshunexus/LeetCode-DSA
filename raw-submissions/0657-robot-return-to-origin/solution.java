class Solution {
    public boolean judgeCircle(String moves) {
        int upDown = 0;
        int leftRight = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') upDown++;
            else if (move == 'D') upDown--;
            else if (move == 'L') leftRight++;
            else if (move == 'R') leftRight--;
        }
        return upDown == 0 && leftRight == 0;
    }
}
