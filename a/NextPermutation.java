class Solution {
    public void nextPermutation(int[] nums) {
        boolean ascending = true;
        int idx = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i - 1;
                ascending = false;
                break;
            }
        }

        if (ascending) {
            reverse(0, nums.length - 1, nums);
            return;
        }
        
        for (int i = nums.length - 1; i >= idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(i, idx, nums);
                reverse(idx + 1, nums.length - 1, nums);
                break;
            }
        }
        
    }
    
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(i++, j--, nums);
        }
    }
}
