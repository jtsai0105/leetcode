class Solution {
    public int rob(int[] nums) { 
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        
        return Math.max(maxRob(nums, 0, n - 2), maxRob(nums, 1, n - 1));
    }
    
    private int maxRob(int[] nums, int l, int r) {
        int[][] dp = new int[r - l + 1][2];
        dp[0][1] = nums[l];
        for (int i = 1; i + l <= r; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i + l];
        }
        return Math.max(dp[r - l][0], dp[r - l][1]);
    }
}
