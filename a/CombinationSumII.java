class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
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
            if(i > start && nums[i] == nums[i-1]) continue;
            tmp.add(nums[i]);
            helper(res, tmp, nums, remain - nums[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
