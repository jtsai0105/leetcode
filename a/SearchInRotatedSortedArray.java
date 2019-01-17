class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[r] >= nums[mid]) {
                r = mid;
            } else {
                l = l + 1;
            }
        }
        
        int k = l;
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[(mid + k) % n] == target) {
                return (mid + k) % n;
            } else if (nums[(mid + k) % n] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return -1;
    }
}
