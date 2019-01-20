class Solution {
    public int rob(int[] nums) { 
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int n = nums.length;
        int res1;
        int res2;
        int tmp = nums[0];
        int[][] dp = new int[n - 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }
        
        res1 = Math.max(dp[n - 2][0], dp[n - 2][1]);
        
        dp[0][0] = 0;
        dp[0][1] = nums[1];
        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i + 1] + dp[i - 1][0];
        }
        
        res2 = Math.max(dp[n - 2][0], dp[n - 2][1]);
        
        return Math.max(res1, res2);
    }
}
