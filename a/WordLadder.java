class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> que = new LinkedList<>();
        int depth = 0;
        que.offer(beginWord);
        while (!que.isEmpty()) {
            depth++;
            int size = que.size();
            for (int j = 0; j < size; j++) {
                String word = que.poll();
                if (word.equals(endWord)) {
                    return depth;
                }
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String w = new String(chars);
                        if (wordSet.contains(w)) {
                            que.offer(w);
                            wordSet.remove(w);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
