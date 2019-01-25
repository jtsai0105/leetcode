class Solution {

    private TreeMap<Integer, Integer> map;
    private static Random random;
    private int sum;
    public Solution(int[] w) {
        map = new TreeMap<>();
        random = new Random();
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
        
        this.sum = sum;
    }
    
    public int pickIndex() {
        int key = map.ceilingKey(random.nextInt(sum) + 1);
        return map.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
