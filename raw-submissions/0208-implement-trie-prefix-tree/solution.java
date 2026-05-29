class Trie {
    private static class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        public TrieNode() {
            child = new TrieNode[26];
            isEnd = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
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
        TrieNode curr = traverse(word);
        return curr != null && curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }
    private TrieNode traverse(String s){
        TrieNode curr = root;
        for(char c : s.toCharArray()){
            int idx = c - 'a';
            if(curr.child[idx] == null)
                return null;
            curr = curr.child[idx];
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
