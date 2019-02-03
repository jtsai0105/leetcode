class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int[] p : points) {
            pq.offer(new int[]{p[0], p[1], distance(p)});
            if (pq.size() > K) {
                pq.poll();
            }
        }
        
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] p = pq.poll();
            res[i] = new int[]{p[0], p[1]};
        }
        
        return res;
    }
    
    private int distance(int[] point) {
        return (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2);
    }
}
