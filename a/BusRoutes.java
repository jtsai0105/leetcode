class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Queue<Integer> que = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        if (S == T) {
            return 0;
        }
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.putIfAbsent(routes[i][j], new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }
        
        int res = 0;
        
        que.offer(S);
        while (!que.isEmpty()) {
            res++;
            for (int i = que.size(); i > 0; i--) {
                int cur = que.poll();
                List<Integer> buses = map.get(cur);
                for (int bus : buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return res;
                        que.offer(routes[bus][j]);  
                    }
                }
            }    
        }
        
        return -1;
    }
}
