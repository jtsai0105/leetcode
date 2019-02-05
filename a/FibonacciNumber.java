class Solution {
    public int fib(int N) {
        int a0 = 0, a1 = 1;
        if (N <= 1) {
            return N == 0 ? a0 : a1;
        }
        
        for (int i = 2; i <= N; i++) {
            int tmp = a1;
            a1 = a1 + a0;
            a0 = tmp;
        }
        
        return a1;
    }
}
