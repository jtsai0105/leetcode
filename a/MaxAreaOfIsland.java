class Solution {
    private int res;
    private int tmp;
    
    public int maxAreaOfIsland(int[][] grid) {
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    tmp = 0;
                    dfs(grid, i, j);
                    res = Math.max(tmp, res);
                }
            }
        }
        return res;
    }
    
    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == 0) {
            return;
        }
        tmp++;
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
