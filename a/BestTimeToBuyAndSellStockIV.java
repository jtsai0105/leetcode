class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        
        if (k >= n / 2) {
            return greedy(prices);
        }
        
        int[][] dp = new int[k + 1][n];
//         i: transcation
//         j: days
//         dp[i][j] = Max(dp[i][j - 1], prices[j] - prices[m] + dp[i - 1][m] for m = 0 ~ j - 1);

        for (int i = 0; i < k; i++) {
            dp[i][0] = 0;
        } 
        
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i < k + 1; i++) {
            int tmp = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                tmp = Math.max(tmp, dp[i - 1][j] - prices[j]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmp);
            }
        }
        
        return dp[k][n - 1];
    }
    
    private int greedy(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            res += profit > 0 ? profit : 0;
        }
        
        return res;
    }
}
