class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        dfs(res, str, 0, 0, n);
        
        return res;
    }
    
    private void dfs(List<String> res, String s, int open, int close, int max) {
        if (s.length() == max * 2) {
            res.add(s);
            return;
        }
        
        if (open < max) {
            dfs(res, s + "(", open + 1, close, max);
        }
        
        if (close < open) {
            dfs(res, s + ")", open, close + 1, max);
        }
    }
}
