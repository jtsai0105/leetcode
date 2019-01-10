class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        tmp.add(nums[idx]);
        helper(res, tmp, nums, idx + 1);
        tmp.remove(tmp.size() - 1);
        helper(res, tmp, nums, idx + 1);
    }
}
