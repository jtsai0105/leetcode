/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> tmp, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(tmp));
        }
        helper(res, tmp, root.left, sum);
        helper(res, tmp, root.right, sum);
        tmp.remove(tmp.size() - 1);
    }
}
