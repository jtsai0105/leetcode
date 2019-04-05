class Solution {
    public int pivotIndex(int[] nums) {
        
        if (nums.length == 0) {
            return -1;
        }
        
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - cur - nums[i] == cur) {
                return i;
            }
            cur += nums[i];
        }
        
        return -1;
    }
}
