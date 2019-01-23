class Solution {
    Map<String, Boolean> map;
    char[] numbers;
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        
        map = new HashMap<>();
        numbers = new char[maxChoosableInteger + 1];
        Arrays.fill(numbers, '1');
        
        return dfs(desiredTotal);
        
    }
    
    private boolean dfs(int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        String key = new String(numbers);
        
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        boolean res = false;
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == '0') {
                continue;
            }
            numbers[i] = '0';
            if (!dfs(desiredTotal - i)) {
                res = true;
            }
            numbers[i] = '1';
            if (res) {
                break;
            }
        }
        
        map.put(key, res);
        
        return res;
    }
}
