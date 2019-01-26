class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    private int find(int x) {
        if (!map.containsKey(x)) {
            map.put(x, x);
            islands++;
        }
        
        if (map.get(x) != x) {
            return find(map.get(x));
        }
        return x;
    }
    
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            map.put(x, y);
            islands--;
        }
    }
    
}
