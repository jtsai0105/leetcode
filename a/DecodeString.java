class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<String> words = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int idx = 0;
        
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int cnt = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    cnt = cnt * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                count.push(cnt);
            } else if (s.charAt(idx) == '[') {
                words.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder tmp = new StringBuilder(words.pop());
                int repeatTimes = count.pop();
                while (repeatTimes > 0) {
                    tmp.append(res);
                    repeatTimes--;
                }
                res = tmp.toString();
                idx++;
            } else {
                res += s.charAt(idx);
                idx++;
            }
        }
        
        return res;
    }
}
