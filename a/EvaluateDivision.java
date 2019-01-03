class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] res = new double[queries.length];
        
        for (int i = 0; i < equations.length; i++) {
            if (map.get(equations[i][0]) == null) {
                map.put(equations[i][0], new HashMap<>());
            }
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            
            if (map.get(equations[i][1]) == null) {
                map.put(equations[i][1], new HashMap<>());
            }
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        
        for (int i = 0; i < queries.length; i++) {
            double ans = search(queries[i][0], queries[i][1], 1.0, map, new HashSet<>());
            res[i] =  ans == 0.0 ? -1.0 : ans;
        }
        
        return res;
    }
    
    private double search(String start, String end, double value, Map<String, Map<String, Double>> map, Set<String> set) {
        if (map.containsKey(start) && map.get(start).get(end) != null) {
            return value * map.get(start).get(end);
        }
        if (set.contains(start)) {
            return 0.0;
        }
        set.add(start);
        if (map.containsKey(start)) {
            for (Map.Entry<String, Double> entry : map.get(start).entrySet()) {
                double res =search(entry.getKey(), end, value * entry.getValue(), map, set);
                if (res != 0.0) {
                    return res;
                }
            }
        }
        
        return 0.0;
    }
}
