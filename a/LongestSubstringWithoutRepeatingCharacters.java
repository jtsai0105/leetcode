class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0;
        int res = 0;
        
        while (end < s.length()) {
            Character c = s.charAt(end);
            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(c);
            res = Math.max(res, end - start + 1);
            end++;
        }
        
        return res;
    }
}
