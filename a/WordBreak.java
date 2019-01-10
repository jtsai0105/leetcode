class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] isWord = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if ((i - word.length() == -1 || (i - word.length() >= 0 && isWord[i - word.length()])) && s.substring(i - word.length() + 1, i + 1).equals(word)) {
                    isWord[i] = true; 
                }
                if (isWord[isWord.length - 1] == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
