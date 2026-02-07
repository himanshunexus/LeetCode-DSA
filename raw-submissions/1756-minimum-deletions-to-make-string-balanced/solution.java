class Solution {
    public int minimumDeletions(String s) {
        int res = 0;
        int bCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else {
                if (bCount > 0) {
                    res++;
                    bCount--;
                }
            }
        }
        return res;
    }
}
