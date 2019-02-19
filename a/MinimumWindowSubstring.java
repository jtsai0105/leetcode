class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = t.length();
        int min = Integer.MAX_VALUE;
        int begin = 0, head = 0;;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int n = map.get(s.charAt(i));
                if (n > 0) {
                    count--;
                }
                map.put(s.charAt(i), n - 1);
            
                while (count == 0) {
                    if (i - begin + 1 < min) {
                        min = i - (head = begin) + 1;
                    }
                
                    if (map.containsKey(s.charAt(begin)) && map.get(s.charAt(begin)) == 0) {
                        count++;
                    }
                    if (map.containsKey(s.charAt(begin))) map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
                    begin++;
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }
}
