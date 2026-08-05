class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int c : citations) {
            count[Math.min(c, n)]++;
        }

        int totalPapers = 0;
        for (int i = n; i >= 0; i--) {
            totalPapers += count[i];
            
            if (totalPapers >= i) {
                return i;
            }
        }

        return 0;
    }
}

// X H Index tab hi hoga jab scientist ne x ya x se jada quality wale paper likhe ho 
// or Atleast x paper publish kiye ho
