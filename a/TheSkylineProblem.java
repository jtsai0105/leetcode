class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[] {building[0], -building[2]}); // start
            points.add(new int[] {building[1], building[2]}); // end
        }
        
        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int max = 0;
        pq.offer(0);
        List<int[]> res = new ArrayList<>();
        
        for (int i = 0; i < points.size(); i++) {
           if (points.get(i)[1] < 0) {
               pq.offer(-points.get(i)[1]);
           } else {
               pq.remove(points.get(i)[1]);
           }
            
           if (max != pq.peek()) {
               max = pq.peek();
               res.add(new int[] {points.get(i)[0], pq.peek()});
           }
        }
        
        return res;
    }
}
