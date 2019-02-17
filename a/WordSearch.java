class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wordArray = word.toCharArray();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, wordArray, 0, vis, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, char[] word, int idx, boolean[][] vis, int i, int j) {
        if (idx == word.length) {
            return true;
        }
        
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != word[idx] || vis[i][j]) {
            return false;
        }
        
        vis[i][j] = true;
        boolean res = dfs(board, word, idx + 1, vis, i - 1, j) ||
            dfs(board, word, idx + 1, vis, i + 1, j) ||
            dfs(board, word, idx + 1, vis, i, j - 1) ||
            dfs(board, word, idx + 1, vis, i, j + 1);
        vis[i][j] = false;
        
        return res;
    }
}
