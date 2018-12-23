class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        dfs("", digits, 0, res);
    	return res;
    }
    
    private void dfs(String cur, String digits, int offset, List<String> res) {
        if (offset == digits.length()) {
            res.add(cur);
            return;
        }
        
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (char c : letters.toCharArray()) {
            dfs(cur + c, digits, offset + 1, res);
        }
        
    }
}
