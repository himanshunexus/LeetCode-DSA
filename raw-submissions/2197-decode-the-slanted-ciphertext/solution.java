class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int r = 0, c = i; r < rows && c < cols; r++, c++) {
                res.append(encodedText.charAt(r * cols + c));
            }
        }
        int last = res.length() - 1;
        while (last >= 0 && res.charAt(last) == ' ') {
            last--;
        }
        return res.substring(0, last + 1);
    }
}
