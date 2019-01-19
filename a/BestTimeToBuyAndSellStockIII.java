class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[3][n];
//         i: transcation
//         j: days
//         dp[i][j] = Max(dp[i][j - 1], prices[j] - prices[m] + dp[i - 1][m] for m = 0 ~ j - 1);

        for (int i = 0; i < 3; i++) {
            dp[i][0] = 0;
        } 
        
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        int k = 2;
        for (int i = 1; i < k + 1; i++) {
            int tmp = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                tmp = Math.max(tmp, dp[i - 1][j] - prices[j]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmp);
            }
        }
        
        return dp[2][n -1];
    }
}
