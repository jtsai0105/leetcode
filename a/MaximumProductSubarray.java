class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int min = nums[0], max = nums[0];
        int res = nums[0];
        int tmp;
        for (int i = 1; i < n; i++) {
            tmp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(tmp * nums[i], min * nums[i]));
            res = Math.max(res, max);
        }
        
        return res;
    }
}
