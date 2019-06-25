class Solution {
    public String countAndSay(int n) {
        String res = "1";
        
        if (n == 1) {
            return res;
        }
        
        for (int i = 2; i <= n; i++) {
            int count = 0;
            Character pre = null;
            StringBuilder sb = new StringBuilder();
            for (char c : res.toCharArray()) {
                if (pre == null) {
                    pre = c;
                    count = 1;
                } else if (pre != c) {
                    sb.append(count).append(pre);
                    pre = c;
                    count = 1;
                } else {
                    count++;
                }
            }
            res = sb.append(count).append(pre).toString();
        }
        
        return res;
    }
}
