class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] nodes = new int[n];
        Arrays.fill(nodes, -1);
        
        for (int[] edge : edges) {
            int x = find(nodes, edge[0]);
            int y = find(nodes, edge[1]);
            
            if (x == y) {
                return false;
            }
            
            nodes[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    private int find(int[] nodes, int val) {
        if (nodes[val] == -1) {
            return val;
        }
        return find(nodes, nodes[val]);
    }
}
