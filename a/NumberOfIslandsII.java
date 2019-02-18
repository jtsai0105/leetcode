class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(m <= 0 || n <= 0) return res;

        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        
        for (int[] position : positions) {
            int id = position[0] * n + position[1];
            roots[id] = id;
            count++;
            
            for (int[] dir : dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                int nb = n * x + y;
                
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) {
                    continue;
                }
                
                int rootNb = find(roots, nb);
                if(id != rootNb) {     
                    roots[id] = rootNb;
                    id = rootNb;
                    count--;               
                }
            }
            res.add(count);
        }
        
        
        return res;
    }
    
    private int find(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
