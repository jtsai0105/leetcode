class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] p = normalize(pattern);
        
        for (String word : words) {
            if (Arrays.equals(normalize(word), p)) {
                res.add(word);
            }
        }
        return res;
    }
    
    private int[] normalize(String str) {
        int[] res = new int[str.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.putIfAbsent(str.charAt(i), map.size());
            res[i] = map.get(str.charAt(i));
        }
        
        return res;
    }
}
