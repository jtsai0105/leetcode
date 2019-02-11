class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1Idx = -1;
        int w2Idx = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1Idx = i;
            } else if (words[i].equals(word2)) {
                w2Idx = i;
            }
            if (w1Idx != -1 && w2Idx != -1) {
                res = Math.min(Math.abs(w1Idx - w2Idx), res);
            }
        }
        
        return res;
    }
}
