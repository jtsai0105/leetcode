class WordDictionary {
    
    class TrieNode {
        char character;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode(char character) {
            this.character = character;
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            cur.children.putIfAbsent(c, new TrieNode(c));
            cur = cur.children.get(c);
            if (i == word.length() - 1) {
                cur.isWord = true;
            }
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    private boolean dfs(String word, int idx, TrieNode cur) {
        if (idx == word.length()) {
            return cur.isWord;
        }
        
        char c = word.charAt(idx);
        boolean res = false;
       
        if (c == '.') {
            for (Map.Entry<Character, TrieNode> entry : cur.children.entrySet()) {
                res |= dfs(word, idx + 1, entry.getValue());
            }
        } else if (!cur.children.containsKey(c)) {
            return res;
        } else {
            return dfs(word, idx + 1, cur.children.get(c));
        }
        
        return res;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
