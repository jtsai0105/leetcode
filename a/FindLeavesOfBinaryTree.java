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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        post(root, res);
        return res;
    }
    
    private int post(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return 0;
        }
        
        int level = Math.max(post(root.left, res), post(root.right, res)) + 1;
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(root.val);
        
        return level;
    }
}
