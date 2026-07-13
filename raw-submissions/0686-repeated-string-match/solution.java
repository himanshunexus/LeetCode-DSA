class Solution {
    public int repeatedStringMatch(String a, String b) {
        String temp = a;
        int count = 1;
        int maxLimit = (b.length() / a.length()) + 2; 
        while (count <= maxLimit) {
            if (temp.contains(b)) {
                return count; 
            }
            temp = temp + a;
            count++;
        }
        return -1;
    }
}
