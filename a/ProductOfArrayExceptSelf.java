class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length + 2];
        int[] reverseProduct = new int[nums.length + 2];
        int[] res = new int[nums.length];
        Arrays.fill(product, 1);
        Arrays.fill(reverseProduct, 1);
        
        for (int i = 0; i < nums.length; i++) {
            product[i + 1] = product[i] * nums[i];
        }
        
        for (int i = nums.length - 1; i >= 0; i-- ) {
            reverseProduct[i + 1] = reverseProduct[i + 2] * nums[i];
        }
        
        for (int i = 0; i < res.length; i++) {
            res[i] = product[i] * reverseProduct[i + 2];
        }
        
        return res;
    }
}
