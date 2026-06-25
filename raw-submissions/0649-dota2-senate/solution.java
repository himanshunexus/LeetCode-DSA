class Solution {
    boolean solve(byte[] arr, int rBan, int dBan) {
        int r = 0, d = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'R') {
                if (dBan > 0) {
                    dBan--;
                    arr[i] = 'X';
                } else {
                    r++;
                    rBan++;
                }
            } else if (arr[i] == 'D') {
                if (rBan > 0) {
                    rBan--;
                    arr[i] = 'X';
                } else {
                    d++;
                    dBan++;
                }
            }
        }
        if (r == 0) return false;
        if (d == 0) return true;
        return solve(arr, rBan, dBan);
    }

    public String predictPartyVictory(String senate) {
        return solve(senate.getBytes(), 0, 0) ? "Radiant" : "Dire";
    }
}
