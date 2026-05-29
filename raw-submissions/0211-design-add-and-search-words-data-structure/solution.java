class WordDictionary {
    private static class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        public TrieNode() {
            child = new TrieNode[26];
            isEnd = false;
        }
    }
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return traverse(word, 0 , root);
    }
    private boolean traverse(String word , int index , TrieNode curr){
        if (index == word.length()) {
        return curr.isEnd;
    }
    
    char c = word.charAt(index);
    
    if (c == '.') {
        for (int i = 0; i < 26; i++) {
            if (curr.child[i] != null) {
                if (traverse(word, index + 1, curr.child[i])) {
                    return true;
                }
            }
        }
        return false;
    } else {
        int idx = c - 'a';
        if (curr.child[idx] == null) {
            return false;
        }
        return traverse(word, index + 1, curr.child[idx]);
        }
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
