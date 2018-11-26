class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i] - prices[i - 1];
            res += cur > 0 ? cur : 0;
        }
        
        return res;
    }
}
