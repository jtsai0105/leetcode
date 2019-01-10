class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> palindromeSet = new ArrayList<>();
        helper(res, palindromeSet, s);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> palindromeSet, String s) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(palindromeSet));
            return;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s, 0,  i - 1)) {
                palindromeSet.add(s.substring(0, i));
                helper(res, palindromeSet, s.substring(i));
                palindromeSet.remove(palindromeSet.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int i , int j) {        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
