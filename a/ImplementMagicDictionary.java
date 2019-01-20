class MagicDictionary {

    private Map<String, List<int[]>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            for (int i = 0; i < str.length(); i++) {
                String key = str.substring(0, i) + str.substring(i + 1);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[] {str.charAt(i), i});
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) {
                for (int[] candidate : map.get(key)) {
                    if (i == candidate[1] && word.charAt(i) != candidate[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
