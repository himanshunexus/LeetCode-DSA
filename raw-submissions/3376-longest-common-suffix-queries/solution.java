class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIndex = -1;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < wordsContainer.length; i++) {
            updateTrie(root, wordsContainer, i);
        }

        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = queryTrie(root, wordsContainer, wordsQuery[i]);
        }
        return ans;
    }

    private void updateTrie(TrieNode root, String[] wordsContainer, int index) {
        TrieNode curr = root;
        String s = wordsContainer[index];
        if (curr.bestIndex == -1 || s.length() < wordsContainer[curr.bestIndex].length()) {
            curr.bestIndex = index;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            int charIdx = s.charAt(i) - 'a';
            if (curr.children[charIdx] == null) {
                curr.children[charIdx] = new TrieNode();
            }
            curr = curr.children[charIdx];
            if (curr.bestIndex == -1 || s.length() < wordsContainer[curr.bestIndex].length()) {
                curr.bestIndex = index;
            }
        }
    }

    private int queryTrie(TrieNode root, String[] wordsContainer, String query) {
        TrieNode curr = root;
        int lastBest = root.bestIndex;

        for (int i = query.length() - 1; i >= 0; i--) {
            int charIdx = query.charAt(i) - 'a';
            if (curr.children[charIdx] == null) {
                return lastBest;
            }
            curr = curr.children[charIdx];
            lastBest = curr.bestIndex;
        }
        return lastBest;
    }
}
