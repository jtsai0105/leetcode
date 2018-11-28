class Solution {
    public int climbStairs(int n) {
        int n1 = 1;
        int n2 = 2;
        if (n == 1 || n == 2) {
            return n;
        }
        
        for (int i = 3; i <= n; i++) {
            int tmp = n2;
            n2 += n1;
            n1 = tmp;
        }
        
        return n2;
    }
}
