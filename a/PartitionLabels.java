class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] wordArray = S.toCharArray();
        int[] map = new int[26];
        
        for (int i = 0; i < wordArray.length; i++) {
            map[wordArray[i] - 'a'] = i;
        }
        
        int start = 0;
        int last = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < wordArray.length; i++) {
            last = Math.max(last, map[wordArray[i] - 'a']);
            if (last == i) {
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        
        return res;
    }
}
