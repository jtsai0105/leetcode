class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if(times == null || times.length == 0){
            return -1;
        }
        
        Map<Integer, Map<Integer, Integer>> path = new HashMap<>();
        for (int[] time : times) {
            if (!path.containsKey(time[0])) {
                path.put(time[0], new HashMap<>());
            }
            if (path.get(time[0]).get(time[1]) == null ||
               path.get(time[0]).get(time[1]) > time[2]) {
                path.get(time[0]).put(time[1], time[2]);
            }
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, Integer> distanceMap = new HashMap<>();
    
        distanceMap.put(K, 0);
        pq.offer(new int[]{K, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int distance = cur[1];

            // Ignore processed nodes
            if(distanceMap.containsKey(node) && distanceMap.get(node) < distance){
                continue;
            }
            
            Map<Integer, Integer> sourceMap = path.get(node);
            if(sourceMap == null){
                continue;
            }
            for(Map.Entry<Integer, Integer> entry : sourceMap.entrySet()){
                int absoluteDistence = distance + entry.getValue();
                int targetNode = entry.getKey();
                if(distanceMap.containsKey(targetNode) && distanceMap.get(targetNode) <= absoluteDistence){
                    continue;
                }
                distanceMap.put(targetNode, absoluteDistence);
                pq.offer(new int[]{targetNode, absoluteDistence});
            }
        }
        
        return distanceMap.size() == N ? Collections.max(distanceMap.values()) : -1;
    }
}
