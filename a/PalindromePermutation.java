class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (int n : map.values()) {
            if (n % 2 != 0) {
                odd++;
            }
        }
        
        return odd <= 1;
    }
}
