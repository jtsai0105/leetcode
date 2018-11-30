class Solution {
    public boolean isPalindrome(int x) {
        int rx = 0;
        if (x<0 || (x!=0 && x%10==0)) return false;
        
        while (rx <= x) {
            if (rx == x || x/10 == rx) {
                return true;
            }
            rx = rx * 10 + x%10;
            x /= 10;
        }
        
        return false;
    }
}
