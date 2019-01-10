class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, List<Integer> tmp, int [] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }
        
        if (remain == 0) {
            res.add(new ArrayList<>(tmp));
        }
        
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(res, tmp, nums, remain - nums[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
