class Solution {
    public int maxProfit(int[] prices) {
        int curMax = 0;
        int res = curMax;
        for (int i = 1; i < prices.length; i++) {
            curMax = curMax + prices[i] - prices[i-1] > 0 ? curMax + prices[i] - prices[i-1]: 0;
            res = Math.max(res, curMax);
        }
        
        return res;
    }
}
