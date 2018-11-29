class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = curMax + nums[i] < nums[i] ? nums[i] : curMax + nums[i];
            res = Math.max(res, curMax);
        }
        return res;
    }
}
