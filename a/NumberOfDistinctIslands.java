class Solution {
    private Set<String> set = new HashSet<>();
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, sb, i, j, 'o');
                    set.add(sb.toString());
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int[][] grid, StringBuilder sb, int i, int j, char c) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) {
            return;
        }
        
        sb.append(c);
        grid[i][j] = 0;
        dfs(grid, sb, i + 1, j, 'd');
        dfs(grid, sb, i - 1, j, 'u');
        dfs(grid, sb, i, j - 1, 'l');
        dfs(grid, sb, i, j + 1, 'r');
        sb.append("b"); 
    }
}
