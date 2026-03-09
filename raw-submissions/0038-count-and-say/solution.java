class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        for (int iteration = 1; iteration < n; iteration++) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            
            while (i < result.length()) {
                char currentChar = result.charAt(i);
                int count = 0;
                while (i < result.length() && result.charAt(i) == currentChar) {
                    count++;
                    i++;
                }
                sb.append(count).append(currentChar);
            }
            
            result = sb.toString();
        }
        return result;
    }
}
