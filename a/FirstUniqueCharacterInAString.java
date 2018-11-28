class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        
        int minIndex = Integer.MAX_VALUE;
        for (Character key : map.keySet()) {
            if (map.get(key) != -1 && map.get(key) < minIndex) {
                minIndex = map.get(key).intValue();
            }
        }
        
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}
