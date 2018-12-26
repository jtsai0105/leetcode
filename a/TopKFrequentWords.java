class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        
        List<String> res = new LinkedList<>();
        map.forEach((key, value) -> {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        });
        
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        
        return res;
    }
}
