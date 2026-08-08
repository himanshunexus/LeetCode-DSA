class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last = new int[m];
        for (int i = 0; i < m; i++) {
            last[i] = -1;
        }

        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
        }

        int[] result = new int[m];
        boolean usedChange = false;
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            boolean isMatch = word1.charAt(p1) == word2.charAt(p2);
            boolean canChangeHere = !usedChange && (p2 == m - 1 || last[p2 + 1] > p1);

            if (isMatch || canChangeHere) {
                if (!isMatch) {
                    usedChange = true;
                }
                result[p2] = p1;
                p2++;
            }
            p1++;
        }
        return p2 == m ? result : new int[0];
    }
}
