class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            long totalWeight = 0;
            for (char c : word.toCharArray()) {
                totalWeight += weights[c - 'a'];
            }
            int val = (int) (totalWeight % 26);
            char mappedChar = (char) ('z' - val);
            sb.append(mappedChar);
        }
        return sb.toString();
    }
}
