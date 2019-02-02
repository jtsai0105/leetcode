class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if ((!Character.isDigit(c) && c != ' ')) {
                switch (c) {
                    case '+':
                        res += sign * num;
                        sign = 1;
                        num = 0;
                        break;
                    case '-':
                        res += sign * num;
                        sign = -1;
                        num = 0;
                        break;
                    case '(':
                        stack.push(res);
                        stack.push(sign);
                        res = 0;
                        sign = 1;
                        break;
                    case ')':
                        res += sign * num;
                        res *= stack.pop();
                        res += stack.pop();
                        num = 0;
                        break;
                    default:
                        break;
                }
            }
        }
        
        res += sign * num;
        
        return res;
    }
}
