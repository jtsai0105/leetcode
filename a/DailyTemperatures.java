class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }
        int n = T.length;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < T.length; i++) {
            while (!s.isEmpty() && T[i] > T[s.peek()]) {
                int idx = s.pop();
                res[idx] = i - idx;
            }
            s.push(i);
        }
        
        return res;
    }
}
